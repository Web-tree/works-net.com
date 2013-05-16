$(document).ready(function(){
    "use strict";
    $("a.modal-link").click(function(){
        var linkText = $(this).text();
        $.ajax({
            type: "GET",
            url: $(this).attr("href") + "?layout=1"
        }).done(function(data){
                var modalWindow = $("#modal-window");
                var modalBody = modalWindow.children(".modal-body");
                var modalHeader = modalWindow.children(".modal-header").children("h3");
                modalHeader.html(linkText);
                modalBody.html(data);
                modalWindow.modal();
        }).fail(function(jqXHR, textStatus) {
            alert( "Request failed: " + textStatus )
        });

        return false;
    });
});