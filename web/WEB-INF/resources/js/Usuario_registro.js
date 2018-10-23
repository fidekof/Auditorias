const produccu = false;


const ambienteruta2 = () => {
    let result = "";
    if (produccu === true) {
        result = "auditoriasV2/"
    }
    return result;
};

const getParamName2 = (newroot) => {
    let currentLocation = window.location;
    let path = currentLocation.pathname;
    let parts = path.split("/");
    while (parts.length > 2) parts.shift();
    return currentLocation.origin + '/' + newroot + '/' + parts.join('/');
};


const SaveDataUserOneFetch = async () => {
    const cedula = document.getElementById("ced").value;
    const longname = document.getElementById("longname").value;
    const codjde = document.getElementById("codjde").value;
    const codPerf = document.getElementById("perfil").value;
    if ((cedula === null || cedula.length < 1 || cedula.trim().length < 1)) {
        M.toast({html: `Debe ingresar Cédula`, classes: 'rounded red lighten-1'});
        return {};
        // return {};
    }
    if ((longname === null || longname.length < 1 || longname.trim().length < 1)) {
        M.toast({html: `Debe ingresar Nombres`, classes: 'rounded red lighten-1'});
        return {};
        //return {};
    }
    if ((codPerf === "999" || codPerf === null || codPerf.length < 1 || codPerf.trim().length < 1)) {
        /*  alert('Seleccione Perfil Asignar');*/
        M.toast({html: `Seleccione Perfil Asignar`, classes: 'rounded red lighten-1'});
        return {};
        //return {};
    }
    const url2 = getParamName2(`${ambienteruta2()}Usuario/Add/User/${cedula.trim()}/${longname.trim()}/${codjde.trim()}/${codPerf}`).replace("/Login/Menu", "").replace("/Menu/aud", "").replace("/Registro/audx", "");
    const myHeaders2 = new Headers();
    myHeaders2.append('Accept', 'application/json');
    myHeaders2.append('Content-Type', 'application/json');

    const userU2 = {
        cedula: `${cedula}`,
        longname: `${longname}`,
        codjde: `${codjde}`,
        codPerf: `${codPerf}`,
    };

    const MyConfig2 = {
        method: 'POST',
        headers: myHeaders2,
        body: JSON.stringify(userU2)
    };

    await fetch(url2, MyConfig2)
        .then(response2 => {
            return response2.json();
        })
        .catch(error => {
            console.log(error);
            M.toast({html: `Error al registrar Usuario!`, classes: 'rounded red lighten-1'});
            return {};
        })
        .then(
            response2 => {

                if (response2 === null) {
                    M.toast({html: `Usuario no existe!`, classes: 'rounded red lighten-1'});
                    return {};
                }
                else {
                    if (response2 == "OK") {
                        M.toast({html: `Usuario Ingresado Correctamente!`, classes: 'rounded green lighten-1'});
                        return {};
                    }
                    else if (response2 == "DUPLICADO") {
                        M.toast({html: `Usuario ya se encuentra Registrado!`, classes: 'rounded red lighten-1'});
                        return {};
                    }
                    else {
                        M.toast({html: `Usuario no existe!`, classes: 'rounded red lighten-1'});
                        return {};
                    }
                }

            }
        );
}

const saveUser = async () => {
    const cedula = document.getElementById("ced").value;
    const longname = document.getElementById("longname").value;
    const codjde = document.getElementById("codjde").value;
    const codPerf = document.getElementById("perfil").value;
    if ((cedula === null || cedula.length < 1 || cedula.trim().length < 1)) {
        //  alert('Debe ingresar Cédula');
        M.toast(
            {
                html: `Debe ingresar Cédula!`,
                classes: 'rounded red lighten-1'
            }
        );
        //return {};
    }
    else if ((longname === null || longname.length < 1 || longname.trim().length < 1)) {
        //   alert('Debe ingresar Nombres');
        // return {};
        M.toast(
            {
                html: `Debe ingresar Nombres!`,
                classes: 'rounded red lighten-1'
            }
        );
    }
    if ((codPerf === "999" || codPerf === null || codPerf.length < 1 || codPerf.trim().length < 1)) {
        // alert('Seleccione Perfil Asignar');
        // return {};
        M.toast(
            {
                html: `Seleccione Perfil Asignar!`,
                classes: 'rounded red lighten-1'
            }
        );
    }
    const url2 = getParamName2(`${ambienteruta2()}Usuario/Add/User/${cedula.trim()}/${longname.trim()}/${codjde.trim()}/${codPerf}`).replace("/Login/Menu", "").replace("/Menu/aud", "").replace("/Registro/audx", "");

    const request2 = {method: 'GET', url: url2};
    const response2 = await ajax(request2);
    switch (response2.status) {
        case 200: {
            const respuesta2 = response2.responseText;
            if (respuesta2.replace("\"", "").replace("\"", "") === 'OK') {
                M.toast(
                    {
                        html: `Usuario Registrado Correctamente!`,
                        classes: 'rounded green lighten-1'
                    }
                );
            } else if (respuesta2.replace("\"", "").replace("\"", "") === 'DUPLICADO') {
                M.toast(
                    {
                        html: `Usuario ya se encuentra registrado!`,
                        classes: 'rounded red lighten-1'
                    }
                );
            }
            else {
                M.toast(
                    {
                        html: `Error al registrar Usuario!`,
                        classes: 'rounded red lighten-1'
                    }
                );
            }
            break;
        }
        case 400: {
            console.log('Error de Usuario' + response2.status);
            break;
        }
        default:
            console.log('Error Desconocido' + response2.status);
    }

};


const saveUserjde = async (typeAud) => {
    saveUser();
    window.location.reload();
};

const getDataUserall = async () => {
    const cedula = document.getElementById("ced_bus");
    const longname = document.getElementById("longname");
    const codjde = document.getElementById("cod_jde");
    if ((cedula.value === null || cedula.value.length < 1 || cedula.value.trim().length < 1) && cedula.parentNode.style.display !== 'none') {
        /* alert('Debe ingresar Cédula a Buscar');*/
        M.toast({html: `Debe ingresar Cédula a Buscar`, classes: 'rounded red lighten-1'});
        return {};
    }
    const url = getParamName(`${ambienteruta()}Usuario/ConsultaALL`).replace("/Login/Menu", "").replace("/Menu/aud", "").replace("/Registro/audx", "");
    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const userC = {
        cedula: `${cedula.value}`,
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
                        M.toast({html: `Usuario no existe!`, classes: 'rounded green lighten-1'});
                        /* alert('Usuario no existe');*/
                        resultado = {};
                    }
                }

            }
        );
    return resultado;
}


const searchall = async (typeAud) => {
    const User = await getDataUserFALL();
    if (User !== null && User.length > 0) {
        // llenarCampos(User);
    }
};


const getDataUserFALL = async () => {
    const cedula = document.getElementById("ced").value;
    const lastname = document.getElementById("longname").value;
    const codperf = document.getElementById("perfil").value;
    const codjde = document.getElementById("codjde").value;
    const url = getParamName(`${ambienteruta()}Usuario/Guardar/${cedula}/${lastname}/${codperf}/${codjde}`).replace("/Inicio/aud", "").replace("/Registro/audx", "");
    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const user = {
        username: `mark23`,
        password: `123456`,
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(user)
    };

    let resultado = {};
    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            console.log(error);
            M.toast({html: `Usuario y/o Contraseña Incorrectas!`, classes: 'rounded red lighten-1'});
            resultado = {};
        })
        .then(
            response => {

                if (response === null) {
                    M.toast({html: `Usuario y/o Contraseña Incorrectas!`, classes: 'rounded red lighten-1'});
                    resultado = {};
                }
                else {
                    if (response.length > 0) {
                        M.toast({
                            html: `Bienvenido al Sistema ${response.toString()}`,
                            classes: 'rounded green lighten-1'
                        });
                        resultado = response;
                    }
                    else {
                        M.toast({html: `Usuario y/o Contraseña Incorrectas!`, classes: 'rounded red lighten-1'});
                        resultado = {};
                    }
                }

            }
        );
    return resultado;
}








