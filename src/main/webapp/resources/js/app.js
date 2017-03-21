/**
 * Created by anderson on 19/03/17.
 */

$( document ).ready(function() {
    $(".cpf").mask("###.###.###-##");

    $("#table").DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros por página",
            "zeroRecords": "Nada encontrado",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "Sem registros disponíveis",
            "infoFiltered": "(filtrado de um _MAX_ total de registros)",
            "search": "Procurar:",
            "paginate": {
                "first": "Primeiro",
                "last": "Último",
                "next": "Próximo",
                "previous": "Anterior"
            }
        }
    });

    $('.valor').mask("###0.00", {reverse: true});

});