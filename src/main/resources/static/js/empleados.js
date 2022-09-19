// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#empleados').DataTable();
});

async function cargarUsuarios(){

     const request = await fetch('api/listarempleados', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
      });
      const usuarios = await request.json();

    let listadoHtml ='';
    for(let usuario of usuarios){
    let btneliminar='<a href="#" onclick="eliminarEmpresa('+usuario[0]+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuarioHtml='<tr><td>'+usuario[0]+'</td><td>'+usuario[1]+'</td><td>'+usuario[2]+'</td><td>'+usuario[3]+'</td><td>'+usuario[4]+'</td><td>'+ btneliminar +'</td></tr>';
    listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

async function eliminarEmpresa(id){
if(!confirm('¿Desea Eliminar este Empleado del Sistema?')){
return
}

const request = await fetch('api/listarempleados/'+ id, {
method: 'DELETE',
headers: {
  'Accept': 'application/json',
  'Content-Type': 'application/json'
},
});
location.reload()
}