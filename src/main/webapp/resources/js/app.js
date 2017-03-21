/**
 * Created by anderson on 19/03/17.
 */
//http://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
function getParameterByName(name, url) {
    if (!url) {
        url = window.location.href;
    }
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
function alerts(){
    var a = getParameterByName("alert");

    switch (a){
        case "ok-add":
            sweetAlert("OK", "Salvo com sucesso!", "success");
            break;
        case "err-add":
            sweetAlert("Oops...", "Não foi possível salvar!", "error");
            break;
        case "ok-del":
            sweetAlert("OK", "Removido com sucesso!", "success");
            break;
        case "err-del":
            sweetAlert("Oops...", "Não foi possível remover!", "error");
            break;
    }
}
$( document ).ready(function() {
    $(".cpf").mask("###.###.###-##");

    $("#table").DataTable({
        "language": {
            "lengthMenu": "Mostrar  _MENU_  registros por página",
            "zeroRecords": "Nada encontrado",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "Sem registros disponíveis",
            "infoFiltered": "(filtrado de um _MAX_ total de registros)",
            "search": "_INPUT_",
            "searchPlaceholder": "Buscar",
            "paginate": {
                "first": "Primeiro",
                "last": "Último",
                "next": "Próximo",
                "previous": "Anterior"
            }
        }
    });

    $('.valor').mask("###0.00", {reverse: true});

    alerts();
});