$(function(){
    $("#userList tr").slice(1).each(function(){  
    	$(this).css('cursor','pointer');
        var p = this;  
        $(this).children().slice(1).click(function(){  
            $($(p).children()[0]).children().each(function(){  
                if(this.type=="checkbox"){  
                    if(!this.checked){  
                        this.checked = true;  
                    }else{  
                        this.checked = false;  
                    }  
                }  
            });  
        });  
    });  
	
});
