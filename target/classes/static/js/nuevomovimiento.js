// Call the dataTables jQuery plugin
$(document).ready(function () {
  cargarempleado();
  colocarnombre();
});

async function cargarempleado() {

  const request = await fetch('api/login', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await request.json();

  let listadoHtml = '';
  for (let usuario of usuarios) {
    let usuarioHtml = '<option value=' +usuario[0]+ '>' + usuario[1] + '</option>';
    listadoHtml += usuarioHtml;
  }

  document.querySelector('#listrol').outerHTML = listadoHtml;

}

async function nuevoEmpleado() {  
  empleado={};
  empleado.nombrecompleto = document.getElementById('txtNombre').value;
  empleado.email = document.getElementById('txtEmail').value;
  empleado.password = document.getElementById('txtPassword').value;
  empleado.rolid= parseInt(document.getElementById('rol').value, 10);
  empleado.empresaid = parseInt(document.getElementById('emp').value, 10);
  let rpassword = document.getElementById('txtRPassword').value;

  console.log(empleado);

  if (empleado.password != rpassword) {
    alert("Las contraseñas no coinciden!")
    return
  }

  if (empleado.nombrecompleto== "" || empleado.email == "" || empleado.password == "" || empleado.rolid == "" || empleado.empresaid == "") {
    alert("Ingrese todos los datos!")
    return
  }

  const request = await fetch('api/listarempleados', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(empleado)
  });
  location.href ="empleados.html";
  const respuesta = await request.text();
 

}

function colocarnombre(){
  document.querySelector('#txtNombreCompleto').outerHTML = localStorage.nombrecompleto;

}