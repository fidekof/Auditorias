const produccion = false;


const ambienteruta = () => {
    let result = "";
    if (produccion === true) {
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


function Menu(dato) {
    var link = '';
    if (dato == 'RUSUARIO') {
        const url = getParamName(`${ambienteruta()}Usuario/Registro/audx`).replace("/Login/Menu", "").replace("/Menu/aud", "");
        $('#content3').attr('src', url);

    }
    if (dato == 'MUSUARIO') {
        const url2 = getParamName(`${ambienteruta()}Usuario/Registro/aud`).replace("/Login/Menu", "").replace("/Menu/aud", "");
        $('#content3').attr('src', url2);
    }

}

$(document).ready(function (e) {
    $('#menu1').on('click', function () {

        $('#content').attr('src', 'Cerrar_Sesion.html');
    });
});
