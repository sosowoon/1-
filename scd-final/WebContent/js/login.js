$(function() {
    // 로그인 페이지로 돌아와서 로그아웃 처리
    $.ajax({
        url: "logout.jsp",
        success: function() {
        }
    })

    // 로그인 처리
    $('#login-submit').click(function() {
        var m_id = $("#m_id").val();
        var pw = $("#pw").val();
        if (m_id == '' || m_id == null) {
            alert('Input your ID!');
            $("#m_id").focus();
        } else if (pw == '' || pw == null) {
            alert('Input your Password!');
            $("#pw").focus();
        } else {
            $.ajax({
                url: "check.jsp",
                data: {
                    m_id: m_id,
                    pw: pw
                },
                success: function(result) {
                    var trimResult = $.trim(result);
                    if (trimResult == 'true') {
                        alert("로그인에 성공하였습니다.");
                        location.href = "index.html";
                    } else {
                        alert("아이디 패스워드를 확인하세요.");
                        location.href = "login.html";
                    }
                }
            });
        }
    });
});