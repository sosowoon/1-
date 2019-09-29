// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

function createPieChart() {		
	$.ajax({
		url: "getTopSellCategories.jsp",
		dataType: "json",
		success: function(result) {
			/* $(result).each(function(i, commercialDistrict) {
				$("#").setText();
			}); */
			var labelsCustom = [];
			var dataCustom = [];
			$(result).each(function(i, sellCategory) {
				labelsCustom.push(sellCategory.sellCategoryName);
				dataCustom.push(sellCategory.sellAmountPercentage);
			});
			
			$("#firstRank").append("<i class='fas fa-circle text-primary'></i> " + labelsCustom[0]);
			$("#secondRank").append("<i class='fas fa-circle text-success'></i> " + labelsCustom[1]);
			$("#thirdRank").append("<i class='fas fa-circle text-info'></i> " + labelsCustom[2]);
			
			// Pie Chart Example
			var ctx = document.getElementById("pieChart");
			var myPieChart = new Chart(ctx, {
			  type: 'doughnut',
			  data: {
			    labels: labelsCustom,
			    datasets: [{
			      data: dataCustom,
			      backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc', '#808080'],
			      hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#696969'],
			      hoverBorderColor: "rgba(234, 236, 244, 1)",
			    }],
			  },
			  options: {
			    maintainAspectRatio: false,
			    tooltips: {
			      backgroundColor: "rgb(255,255,255)",
			      bodyFontColor: "#858796",
			      borderColor: '#dddfeb',
			      borderWidth: 1,
			      xPadding: 15,
			      yPadding: 15,
			      displayColors: false,
			      caretPadding: 10,
			    },
			    legend: {
			      display: false
			    },
			    cutoutPercentage: 80,
			  },
			});
			
		}// success end - 이 안에서 해결해야함
	});
}
