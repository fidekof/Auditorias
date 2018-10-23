const producc = false;


const ambienteruta = () => {
    let result = "";
    if (producc === true) {
        result = "auditoriasV2/"
    }
    return result;
};


const getParamName = (newroot) => {
    let currentLocation = window.location;
    let path = currentLocation.pathname;
    let parts = path.split("/");
    while (parts.length > 2) parts.shift();
    return currentLocation.origin + '/' + newroot + '/' + parts.join('/');
};


const quitarAll = (valor) => {
    let result = "";
    if (valor !== null) {
        result = valor.replace("*", "");
    }
    return result;
};


const getDataUserOneFetch = async () => {
    const cedula = document.getElementById("ced_bus").value;
    const longname = document.getElementById("longname").value;
    const codjde = document.getElementById("codjde").value;
    if ((cedula === null || cedula.length < 1 || cedula.trim().length < 1)) {
        /* alert('Debe ingresar Cédula a Buscar');*/
        M.toast({html: `Debe ingresar Cédula a Buscar`, classes: 'rounded red lighten-1'});
        return {};
    }
    const url = getParamName(`${ambienteruta()}Usuario/ConsultaJDE/${cedula}`).replace("/Login/Menu", "").replace("/Menu/aud", "").replace("/Registro/audx", "");
    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const userC = {
        cedula: `${cedula}`,
        lastname: `${longname}`,
        codigoJde: `${codjde}`,
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(userC)
    };

    let resultado = {};
    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            console.log(error);
            /* alert('Error al Registrar Usuario!');*/
            M.toast({html: `Error al Registrar Usuario!`, classes: 'rounded red lighten-1'});
            resultado = {};
        })
        .then(
            response => {

                if (response === null) {
                    M.toast({html: `Usuario no existe!`, classes: 'rounded red lighten-1'});

                    /* alert('Usuario no existe');*/
                    resultado = {};
                }
                else {
                    if (response.length > 0) {
                        M.toast({html: `Usuario Correcto!`, classes: 'rounded green lighten-1'});
                        /*alert('Usuario Correcto');*/
                        resultado = response;
                    }
                    else {
                        M.toast({html: `Usuario no existe!`, classes: 'rounded red lighten-1'});

                        /* alert('Usuario no existe');*/
                        resultado = {};
                    }
                }

            }
        );
    return resultado;
};


const searchUserjde = async (typeAud) => {
    const User = await getDataUserOneFetch();
    if (User !== null && User.length > 0) {
        llenarCampos(User);
    }
};

const validarNulos = cadena => {
    return cadena !== null ? cadena : " ";
};

function llenarCampos(user) {
    console.log(user);
    user.forEach(
        dato => {
            document.getElementById("ced").value = validarNulos(dato.cedula);
            document.getElementById("longname").value = validarNulos(dato.lastname);
            document.getElementById("codjde").value = validarNulos(dato.codigoJde);
        });

}

/*for (var i = 0; i < user.length; i++) {
    var arr=[]
   /* console.log(arr[i].innerText)
    document.getElementById("ced").value = arr[i].innerText;
    document.getElementById("longname").value = arr[i].innerText;
    document.getElementById("cod_jde").value = arr[i].innerText;
}*/
/*
const contenedor2= document.getElementById("container2");
contenedor2.innerHTML = ``;
let tabla = `
        <div class="signup">
          <form>
             <h4>Información</h4>`;


user.forEach(
    dato => {
        console.log(dato);
        tabla += `

        <input type='text'  id="ced" maxlength="11" readonly="true" placeholder='Cédula:' value="${validarNulos(dato.cedula)}"/>
        <input type='text'  id="longname" placeholder='Nombres:' readonly="true" value="${validarNulos(dato.lastname)}" />
        <div class="select">
            <select id="perfil">
                <option value="999">Perfil:</option>
                <option value="A">Administrador</option>
                <option value="0">Operativo</option>
                <option value="S">Supervisor</option>
            </select>
        </div>
        <input type='text'  id="codjde" placeholder='Cod.jde:' readonly="true" value="${validarNulos(dato.codigoJde)}" />
        <a class="waves-effect waves-light btn" id="btn_save">Registrar</a>
    </form>
</div>
            `;

   });
contenedor2.innerHTML = tabla;
}
**/
