$(document).ready(function(){
    $(".addWorkDetails select").change(function(){
        $(".workDetails").addClass("hidden");
        $(".workDetails."+$("#detailsSelector option:selected").attr("value")).removeClass("hidden");
    });
});