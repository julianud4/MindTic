// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
  });
  
async function iniciarSesion(){
let datos={};
datos.email=document.getElementById('txtEmail').value;
datos.password=document.getElementById('txtPassword').value;
const request = await fetch('api/login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body:JSON.stringify(datos)
    });

    
    const respuesta = await request.json();
    console.log(respuesta);
    if(respuesta[0] !='FAIL'){
      localStorage.token=respuesta[0];
      localStorage.nombrecompleto=respuesta[1];
      window.location.href = "empleados.html"
    }

    else {
    alert("Usuario o contraseña invalidas, Intentemoslo nuevamente")
    }
}