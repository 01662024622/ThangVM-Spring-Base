(function ($) {
    /*==================================================================
    [ Validate ]*/
    var name = $('.validate-input input[name="name"]');
    var userName = $('.validate-input input[name="user"]');
    var pass = $('.validate-input input[name="password"]');
    const user = "vuthang1902";

    $('.validate-form').on('submit',function(){
        var check = true;
        if($(name).val().trim()==""){
            showValidate(name);
            check=false;
        }
        if(checkUser($(userName).val().trim())){
            showValidate(userName);
            check=false;
        }
        if(!$(pass).val().trim().match(/^(?=.*[a-z])(?=.*[0-9])(?=.*[\!\@\#\$%\^\&])(?=.{9,})/)) {
            showValidate(pass);
            check=false;
        }

        return check;
        if (check) {
            alert("submit success full!")
        }
    });


    $('.validate-form .input-box').each(function(){
        $(this).keyup(function(){
            switch ($(this).attr('name')) {
                case name.attr('name'):
                if (!$(this).val()=="") {

                    hideValidate($(this))
                }else {

                    showValidate($(this))
                }
                break;
                case userName.attr('name'):
                if (!checkUser($(this).val().trim())) {
                    hideValidate($(this))
                }else {
                    showValidate($(this))
                }
                break;
                default:
                if ($(this).val().trim().match(/^(?=.*[a-z])(?=.*[0-9])(?=.*[\!\@\#\$%\^\&])(?=.{9,})/)) {
                    hideValidate($(this))
                }else {
                    showValidate($(this))
                }
                break;
            }
        });
    });

    function checkUser(string){
        if (string == ""||string ==user) {
            return true;
        }
        return false;
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
    }  
})(jQuery);