// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#movimientos').DataTable();
  colocarnombre();
});

async function cargarUsuarios(){

     const request = await fetch('api/listarmovimientos', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();

    let listadoHtml ='';
    for(let usuario of usuarios){
    let btneliminar='<a href="#" onclick="eliminar('+usuario[0]+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuarioHtml='<tr><td>'+usuario[0]+'</td><td>'+usuario[1]+'</td><td>'+usuario[2]+'</td><td>'+usuario[3]+'</td><td>'+usuario[4]+'</td><td>'+ btneliminar +'</td></tr>';
    listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

async function eliminar(id){
if(!confirm('¿Desea Eliminar este Movimiento de Dinero del Sistema?')){
return
}

const request = await fetch('api/listarmovimientos/'+ id, {
method: 'DELETE',
headers: {
  'Accept': 'application/json',
  'Content-Type': 'application/json'
},
});
location.reload()
}

function colocarnombre(){
  document.querySelector('#txtNombreCompleto').outerHTML = localStorage.nombrecompleto;

}