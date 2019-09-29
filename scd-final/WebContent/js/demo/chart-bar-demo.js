// Set new default font family and font color to mimic Bootstrap's default
// styling
		Chart.defaults.global.defaultFontFamily = 'Nunito',
		'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function number_format(number, decimals, dec_point, thousands_sep) {
	// * example: number_format(1234.56, 2, ',', ' ');
	// * return: '1 234,56'
	number = (number + '').replace(',', '').replace(' ', '');
	var n = !isFinite(+number) ? 0 : +number, prec = !isFinite(+decimals) ? 0
			: Math.abs(decimals), sep = (typeof thousands_sep === 'undefined') ? ','
			: thousands_sep, dec = (typeof dec_point === 'undefined') ? '.'
			: dec_point, s = '', toFixedFix = function(n, prec) {
		var k = Math.pow(10, prec);
		return '' + Math.round(n * k) / k;
	};
	// Fix for IE parseFloat(0.55).toFixed(0) = 0;
	s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	if (s[0].length > 3) {
		s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	}
	if ((s[1] || '').length < prec) {
		s[1] = s[1] || '';
		s[1] += new Array(prec - s[1].length + 1).join('0');
	}
	return s.join(dec);
}

// DB에서 값 가져오기
var xArry = [];
var yArry = [];
var year_quarter = [];
$.ajax({
	url : "getchart.jsp",
	dataType : "json",
	success : function(result) {

		if (result.length > 0) {
			$(result).each(function(i, val) {
				var year = val.year;
				var quarter = val.quarter;
				var sosma = val.sosma;
				var scsma = val.scsma;

				xArry.push(scsma);
				yArry.push(sosma);
				year_quarter.push(year + "." + quarter);
			});
		}
		drawBarChart();
	}
});

function drawBarChart() {

	// Bar Chart Example
	var ctx = document.getElementById("myBarChart");

	var myBarChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : xArry,
			datasets : [ {
				label : year_quarter,
				hoverBackgroundColor : "#2e59d9",
				borderColor : "#4e73df",
				data : yArry,
			} ],
		},
		options : {
			maintainAspectRatio : false,
			layout : {
				padding : {
					left : 10,
					right : 25,
					top : 25,
					bottom : 0
				}
			},
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : false,
						drawBorder : false
					},
					ticks : {
						maxTicksLimit : 6
					},
					maxBarThickness : 25,
					scaleLabel : {
						display : true,
						labelString : "서울_폐업_영업_개월_평균"
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 150,
						maxTicksLimit : 5,
						padding : 10
					},
					gridLines : {
						color : "rgb(234, 236, 244)",
						zeroLineColor : "rgb(234, 236, 244)",
						drawBorder : false,
						borderDash : [ 2 ],
						zeroLineBorderDash : [ 2 ]
					},
					scaleLabel : {
						display : true,
						labelString : "서울_운영_영업_개월_평균"
					}
				} ],
			},
			legend : {
				display : false
			},
			tooltips : {
				backgroundColor : "rgb(255,255,255)",
				bodyFontColor : "#858796",
				borderColor : '#dddfeb',
				borderWidth : 1,
				xPadding : 15,
				yPadding : 15,
				displayColors : false,
				caretPadding : 10,
				callbacks : {
					title : function(tooltipItem, data) {
						var datasetLabel = year_quarter[tooltipItem.index]
								|| '';
						return datasetLabel
					},
					label : function(tooltipItem, chart) {
						var datasetLabel = year_quarter[tooltipItem.index]
								|| '';

						return "분기:" + datasetLabel + "=>운영평균개월:" + number_format(tooltipItem.yLabel)
								+ ", 폐업평균개월:"
								+ number_format(tooltipItem.xLabel);
					}
				}
			},
		}
	});
}
