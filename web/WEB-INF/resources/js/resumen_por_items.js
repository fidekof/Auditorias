const produccion = true;


const caracteres_especiales = '"&\'*#';

const quitarCaracteres = (cadena, caracteres) => {
    if (cadena != null && cadena.trim().length > 0) {
        if (caracteres_especiales != null && caracteres_especiales.trim().length > 0) {
            caracteres_especiales.split('').forEach(dato => {
                cadena = cadena.replace(dato, '');
            });
        }

        if (caracteres != null && caracteres.trim().length > 0) {
            caracteres.split('').forEach(dato => {
                cadena = cadena.replace(dato, '');
            });
        }
    }
    return cadena;
}


const ambienteruta = () => {
    let result = "";
    if (produccion === true) {
        result = "auditoriasV9/"
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


const getDataItems = async () => {
    const auditoria = (document.getElementById("inp_cod_auditoria")).value;
    const bodega = (document.getElementById("inp_cod_bodega")).value;
    const grupo = (document.getElementById("inp_cod_group")).value;
    const product = (document.getElementById("inp_cod_product")).value;
    const conteo = (document.getElementById("inp_cod_count")).value;


    if (auditoria.length < 1 || auditoria.trim().length < 1) {
        M.toast(
            {
                html: 'Debe inresar un codigo de auditoria',
                classes: 'rounded red lighten-1'
            }
        );
        return {};
    }

    if (conteo.length < 1 || conteo.trim().length < 1) {
        M.toast(
            {
                html: 'Debe Ingresar un codigo de conteo',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }


    if (bodega.length < 1 || bodega.trim().length < 1) {
        M.toast(
            {
                html: 'Debe Ingresar un codigo de bodega',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }


    if (grupo.length < 1 || grupo.trim().length < 1) {
        M.toast(
            {
                html: 'Debe Ingresar su codigo de grupo',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }


    if (product.length < 1 || product.trim().length < 1) {
        M.toast(
            {
                html: 'Debe Ingresar el codigo de producto a buscar',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }

    const url = getParamName(`${ambienteruta()}product/byBodegaAndCode/${bodega}/${product}/${quitarAll(auditoria)}`).replace("/index/noaud", "").replace("/counts/resumen_items", "");
    // const url = `http://localhost:8080/product/byBodegaAndCode/${bodega}/${product}/${quitarAll(auditoria)}`;
    const request = {method: 'GET', url: url};
    const response = await ajax(request);
    switch (response.status) {
        case 200: {
            return JSON.parse(response.responseText);
            break;
        }
        case 400: {
            console.log('Error de cliente' + response.status);
            break;
        }
        default:
            console.log('Error Desconocido' + response.status);
    }
}


const quitarAll = (valor) => {
    let result = "";
    if (valor !== null) {
        result = valor.replace("*", "");
    }
    return result;
}


const getDataProductsFetch2 = async (conteo, tipoBusqueda, url) => {
    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(conteo)
    };


    let resultado = {};
    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            console.log(error);
            M.toast({html: `La busqueda no devolvio resultados`, classes: 'rounded red lighten-1'});
            resultado = {};
        })
        .then(
            response => {

                if (response === null) {
                    M.toast({html: `La busqueda no devolvio resultados`, classes: 'rounded red lighten-1'});
                    resultado = {};
                }
                else {
                    if (response.length > 0) {
                        M.toast({
                            html: `Se encontraron ${response.length} registros`,
                            classes: 'rounded green lighten-1'
                        });
                        resultado = response;
                    }
                    else {
                        M.toast({html: `No se encontraron registros`, classes: 'rounded red lighten-1'});
                        resultado = {};
                    }
                }

            }
        );
    return resultado;
}

const getDataProductsFetch = async () => {
    const auditoria = document.getElementById("inp_cod_auditoria");
    const bodega = (document.getElementById("inp_cod_bodega"));
    const grupo = (document.getElementById("inp_cod_group"));
    const ubicI = (document.getElementById("inp_cod_ubicacion_i"));
    const ubicF = (document.getElementById("inp_cod_ubicacion_f"));
    const conteocode = (document.getElementById("inp_cod_count"));
    const product = (document.getElementById("inp_cod_product"));
    const tipoBusqueda = select_search_id.value;

    if ((auditoria.value === null || auditoria.value.length < 1 || auditoria.value.trim().length < 1) && auditoria.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe inresar un codigo de auditoria', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((bodega.value === null || bodega.value.length < 1 || bodega.value.trim().length < 1) && bodega.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe Ingresar un codigo de bodega', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((grupo.value.length < 1 || grupo.value.trim().length < 1 || grupo.value === null) && (grupo.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar su codigo de grupo', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((conteocode.value === null || conteocode.value.length < 1 || conteocode.value.trim().length < 1) && (conteocode.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar en codigo de su conteo C001, C002, C003', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((ubicI.value === null || ubicI.value.length < 1 || ubicI.value.trim().length < 1) && (ubicI.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar la ubicacion inicial', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((ubicF.value === null || ubicF.value.length < 1 || ubicF.value.trim().length < 1) && (ubicF.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar la ubicacion final', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((product.value === null || product.value.length < 1 || product.value.trim().length < 1) && (product.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar el codigo de productos', classes: 'rounded red lighten-1'});
        return {};
    }


    const tieneT = auditoria.value.indexOf("*");
    // let url = `http://localhost:8080/product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`;
    const url = getParamName(`${ambienteruta()}product/resume_por_items/${tipoBusqueda}`).replace("/counts/resumen_items", "").replace("/counts/resumen_items", "");


    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const conteo = {
        auditoria: `${quitarAll(auditoria.value)}`,
        bodega: `${bodega.value}`,
        grupo: `${grupo.value}`,
        conteocode: `${conteocode.value}`,
        ubicacion: `${ubicI.value}`,
        codigo: `${product.value}`,
        observacion: `${ubicF.value}`
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(conteo)
    };


    let resultado = {};
    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            console.log(error);
            M.toast({html: `La busqueda no devolvio resultados`, classes: 'rounded red lighten-1'});
            resultado = {};
        })
        .then(
            response => {

                if (response === null) {
                    M.toast({html: `La busqueda no devolvio resultados`, classes: 'rounded red lighten-1'});
                    resultado = {};
                }
                else {
                    if (response.length > 0) {
                        M.toast({
                            html: `Se encontraron ${response.length} registros`,
                            classes: 'rounded green lighten-1'
                        });
                        resultado = response;
                    }
                    else {
                        M.toast({html: `No se encontraron registros`, classes: 'rounded red lighten-1'});
                        resultado = {};
                    }
                }

            }
        );
    return resultado;
}


const getDataProducts = async () => {
    const auditoria = (document.getElementById("inp_cod_auditoria")).value;
    const bodega = (document.getElementById("inp_cod_bodega")).value;
    const grupo = (document.getElementById("inp_cod_group")).value;
    const ubicI = (document.getElementById("inp_cod_ubicacion_i")).value;
    const ubicF = (document.getElementById("inp_cod_ubicacion_f")).value;
    const conteo = (document.getElementById("inp_cod_count")).value;

    if (auditoria.length < 1 || auditoria.trim().length < 1) {
        M.toast(
            {
                html: 'Debe inresar un codigo de auditoria',
                classes: 'rounded red lighten-1'
            }
        );
        return {};
    }

    if (bodega.length < 1 || bodega.trim().length < 1) {
        M.toast(
            {
                html: 'Debe Ingresar un codigo de bodega',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }


    if (grupo.length < 1 || grupo.trim().length < 1) {

        M.toast(
            {
                html: 'Debe Ingresar su codigo de grupo',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }


    if (ubicI.length < 1 || ubicI.trim().length < 1) {

        M.toast(
            {
                html: 'Debe Ingresar la ubicacion inicial',
                classes: 'rounded red lighten-1'
            }
        );


        return {};
    }


    if (ubicF.length < 1 || ubicF.trim().length < 1) {

        M.toast(
            {
                html: 'Debe Ingresar la ubicacion final',
                classes: 'rounded red lighten-1'
            }
        );

        return {};
    }

    const tieneT = auditoria.indexOf("*");
    // let url = `http://localhost:8080/product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`;
    let url = getParamName(`${ambienteruta()}product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`);
    if (tieneT < 0) {

        //url = `http://localhost:8080/product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`;

        url = getParamName(`${ambienteruta()}product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`)
    }
    else {
        // url = `http://localhost:8080/product/byBodega/${bodega}/${quitarAll(auditoria)}`;

        url = getParamName(`${ambienteruta()}product/byBodega/${bodega}/${quitarAll(auditoria)}`);
    }
    url = url.replace("/index/noaud", "").replace("/counts/resumen_items", "");
    const request = {method: 'GET', url: url};
    const response = await ajax(request);
    switch (response.status) {
        case 200: {
            return JSON.parse(response.responseText);
            break;
        }
        case 400: {
            console.log('Error de cliente' + response.status);
            break;
        }
        default:
            console.log('Error Desconocido' + response.status);
    }
}


const DrawCountsData = (data, typeAud) => {
    console.log(data);
    const auditoria = (document.getElementById("inp_cod_auditoria")).value;
    const bodega = (document.getElementById("inp_cod_bodega")).value;
    const grupo = (document.getElementById("inp_cod_group")).value;
    const ubicI = (document.getElementById("inp_cod_ubicacion_i")).value;
    const ubicF = (document.getElementById("inp_cod_ubicacion_f")).value;
    const conteo = (document.getElementById("inp_cod_count")).value;
    const contenedorTable = document.getElementById("content-table");


    const tieneT = auditoria.indexOf("*");

    contenedorTable.innerHTML = ``;
    if (data.length > 0) {
        contenedorTable.innerHTML = '';

        let tabla = ``;


        tabla = tablaResumenConteo(data);


        contenedorTable.innerHTML = tabla;
    }
};


const getClassForTr = (flag) => {
    return (flag === true) ? 'class="blue lighten-4"' : '';
}

const tablaResumenConteo = (data) => {
    let tabla = `
        <table class="responsive-table highlight">
        <caption>Resumen de conteo <a id="img_file_download" onclick="exportTableToCSV('auditoria.csv')" class="waves-effect waves-light btn-small light-blue darken-4"><i  class="material-icons left">file_download</i></a></caption>
            <thead>
                <tr>
                    <td>Ubicaciones</td>
                    <td>Item Cod.</td>
                    <td>Descripcion</td>
                    <td>Stock</td>
                    <td>Costo U.</td>
                    <td>Diferencia Final</td>
                    <td>Conteo 1</td>                    
                    <td>Diferencia 1</td>
                    <td>Conteo 2</td>
                    <td>Diferencia 2</td>
                    <td>Conteo 3</td>
                    <td>Diferencia 3</td>
                   
            </thead>
            <tbody>
        `;

    let flag = true;
    data.forEach(
        dato => {
            tabla += `
                <tr ${getClassForTr(flag)}>                         
                   <td>${validarNulos(dato.ubicacion)}</td>
                   <td>${validarNulos(dato.codigo)}</td>
                   <td>${validarNulos(dato.descripcion)}</td>   
                   <td>${validarNulos(dato.cantidad)}</td>
                   <td>${validarNulos(dato.costounitario)}</td>   
                   <td>${validarNulos(validarVacios(dato.conteofinal))}</td>  
                   <td>${validarNulos(validarVacios(dato.conteo1))}</td>  
                   <td>${validarNulos(validarVacios(dato.diferencia1))}</td>  
                   <td>${validarNulos(validarVacios(dato.conteo2))}</td>  
                   <td>${validarNulos(validarVacios(dato.diferencia2))}</td>  
                   <td>${validarNulos(validarVacios(dato.conteo3))}</td>  
                   <td>${validarNulos(validarVacios(dato.diferencia3))}</td>  
                </tr>
            `;
            flag = !flag;
        });
    tabla += ` </tbody></table> `;
    return tabla;
};


const tablaConteos = (data, typeAud, auditoria, grupo, conteo) => {
    let tabla = `
        <table class="responsive-table striped">
            <thead>
                <tr>`;
    if (typeAud === 'Y') {
        tabla += `<th>Cod. Bodega</th>`;
    }
    tabla += `<th>Ubicacion</th>
                    <th>Cod. Item</th>
                    <th>Descripcion</th>`;
    if (typeAud === 'Y') {
        tabla += `<th> Stock </th><th>Costo U.</th>`;
    }

    tabla += `      
                    <th style="display: none">Familia</th> 
                    <th>Conteo Actual</th>
                    <th>Observacion</th>
                    <th>Nueva Ubicacion</th>
                    <th>Acciones</th>
                    
                    
                </tr>
            </thead>
            <tbody>
        `;

    data.forEach(
        dato => {
            const dataByCount = obtenerValorConteo(dato, conteo);

            let imprimir = true;
            // if(conteo.toUpperCase()==='C002' && (dato.cantidad - dato.conteo1)=== 0 ){ifimprimir = false;}
            // else {
            //     if(conteo.toUpperCase()==='C003')
            //     {
            //         if((dato.cantidad - dato.conteo1) !== 0 && (dato.cantidad - dato.conteo2) !== 0 && (dato.conteo1 - dato.conteo2) === 0){ifimprimir = false;}
            //     }
            // }

            if (imprimir === true) {
                tabla += `
                <tr>`;
                if (typeAud === 'Y') {
                    tabla += `<td>${validarNulos(dato.bodega)}</td>`;
                }

                tabla += ` <td>${validarNulos(dato.ubicacion)}</td>
                    <td>${validarNulos(dato.codigo)}</td>
                    <td id="descripcion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}">${validarNulos(dato.descripcion)}</td>`;

                if (typeAud === 'Y') {
                    tabla += `<td>${validarNulos(dato.cantidad)}</td>
                              <td>${validarNulos(dato.costounitario)}</td>`;
                }
                tabla += `
                    
                    <th style="display: none">${validarNulos(dato.familia)}</th> 
                    <td><input id="${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}" onkeyup="saveWithIntro(event,'but_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}')" type="text" value="${validarNulos(validarVacios(dataByCount.conteo))}"></td>
                    <td><input id="observacion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}" type="text" value="${validarNulos(dataByCount.observacion)}"></td>                    
                    <td><input id="new_ubicacion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}" type="text" value="${validarNulos(dato.observacion)}"></td>
                    <td>
                        <i class="material-icons" id="but_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}" onclick="saveCountPost(
                             '${quitarAll(auditoria)}',
                             '${grupo}',
                             '${conteo}',
                             '${dato.bodega}',
                             '${validarNulos2(dato.ubicacion)}',
                             '${dato.codigo}',
                             '${dato.cantidad}',
                             '${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}', 
                             'descripcion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}',
                             '${dato.costounitario}', '${dato.familia}',
                             'observacion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}',
                             'new_ubicacion_${dato.bodega}${validarNulos2(dato.ubicacion)}${dato.codigo}${dato.cantidad}',${dato.idproducto})">save</i></td>
                </tr>
                `;
            }
        });

    tabla += ` </tbody></table> `;
    return tabla;
};


const validarVacios = (valor) => {
    result = '';
    if (valor != null && valor.length > 0 && valor !== -9999.999 && valor !== '-9999.999') {
        result = valor;
    }
    return result;
};


const saveWithIntro = (event, id_element) => {
    if (event.defaultPrevented) {
        return; // Do nothing if the event was already processed
    }

    switch (event.key) {
        case 'Enter': {
            document.getElementById(id_element).click();
        }
    }
}


const searchProductsForCounts = async (typeAud) => {

    // const productos = await getDataProducts();
    const productos = await getDataProductsFetch();
    DrawCountsData(productos, typeAud);

};


const obtenerValorConteo = (dato, conteoCode) => {
    let result = "";
    if (conteoCode !== null && dato != null) {
        if (conteoCode === "C001") {
            result = {
                'conteo': dato.conteo1,
                'observacion': dato.observacion1
            };
        }
        else {
            if (conteoCode === "C002") {
                result = {
                    'conteo': dato.conteo2,
                    'observacion': dato.observacion2
                };
            }
            else {
                if (conteoCode === "C003") {
                    result = {
                        'conteo': dato.conteo3,
                        'observacion': dato.observacion3
                    };
                }
            }
        }

    }
    return result;
}


const validarNulos = cadena => {
    return cadena !== null ? cadena : " ";
};


const validarNulos2 = cadena => {
    return (cadena !== null && cadena.trim().length > 0) ? cadena.trim() : "---";
};

const saveCount = async (codigoAuditoria, codigoGrupo, codConteo, bodega, ubicacion, itemcode, valorInicial, idValorContado, descripcion) => {
    descripcion = descripcion.replace("/", "_");
    const valorConteo = (document.getElementById(`${idValorContado}`)).value;

    // const url =  `http://localhost:8080/product/saveconteo/${codigoAuditoria}/${codigoGrupo}/${codConteo}/${bodega}/${ubicacion}/${itemcode}/${valorInicial}/${valorConteo}/${descripcion}`;
    const url = getParamName(`${ambienteruta()}product/saveconteo/${codigoAuditoria}/${codigoGrupo}/${codConteo}/${bodega}/${ubicacion}/${itemcode}/${valorInicial}/${valorConteo}/${descripcion}`).replace("/index/noaud", "").replace("/counts/resumen_items", "");


    const request = {method: 'GET', url: url};
    const response = await ajax(request);
    switch (response.status) {
        case 200: {
            const respuesta = response.responseText;
            if (respuesta.replace("\"", "").replace("\"", "") === 'OK') {
                M.toast(
                    {
                        html: `Se guardo el conteo del item ${itemcode}`,
                        classes: 'rounded green lighten-1'
                    }
                );
            }
            else {
                M.toast(
                    {
                        html: `No se guardo el conteo del item ${itemcode}`,
                        classes: 'rounded red lighten-1'
                    }
                );
            }
            break;
        }
        case 400: {
            console.log('Error de cliente' + response.status);
            break;
        }
        default:
            console.log('Error Desconocido' + response.status);
    }

};


const searchItemsForCounts = async (typeAud) => {

    const productos = await getDataItems();
    DrawCountsData(productos, typeAud);
};


const saveCountPost = async (auditoria, grupo, conteocode, bodega, ubicacion, itemcode, cantidad, codconteo1, descripcionid, costounitario, familia, codobservacion, cod_new_ubicacion, idproducto) => {
    const descripcion = (document.getElementById(`${descripcionid}`)).innerText;
    const newubucacioncod = (document.getElementById(`${cod_new_ubicacion}`)).value;
    const observacionI = (document.getElementById(`${codobservacion}`)).value;
    const conteo1 = (document.getElementById(`${codconteo1}`)).value;
    const diferencia1 = parseFloat(cantidad) - parseFloat(conteo1);


    //descripcion = (descripcion !== null) ? (descripcion.replace("/", "_").replace("&", " ").replace("(", "_").replace(")", "_")) : "";
    const observacion = (observacionI !== null) ? (observacionI.replace("/", "_").replace("&", " ").replace("(", "_").replace(")", "_")) : "";
    const newubucacion = quitarCaracteres(newubucacioncod);


    if ((ubicacion === null || ubicacion.trim().length < 1 || ubicacion.indexOf("---") !== -1) && (newubucacion === null || newubucacion.trim().length < 1)) {
        M.toast(
            {
                html: `El item ${itemcode} no tiene ubicacion
                Ingresela en el campo nueva ubicacion`,
                classes: 'rounded red lighten-1'
            }
        );

        return;

    }


    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const conteo = {
        auditoria: `${quitarAll(auditoria)}`,
        bodega: `${bodega}`,
        grupo: `${grupo}`,
        conteocode: `${conteocode}`,
        grupoc1: `${grupo}`,
        ubicacion: `${ubicacion}`,
        codigo: `${itemcode}`,
        descripcion: `${quitarCaracteres(descripcion, null)}`,
        cantidad: `${cantidad}`,
        conteo1: `${conteo1}`,
        diferencia1: `${diferencia1}`,
        costounitario: `${costounitario}`,
        familia: `${familia.replace('"', ' ')}`,
        observacion1: `${quitarCaracteres(observacion, null)}`,
        observacion: `${validarNulos2(newubucacion)}`,
        idproducto: `${idproducto}`
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(conteo)
    };


    // const url =  `http://localhost:8080/product/saveconteo/postmode`;
    const url = getParamName(`${ambienteruta()}product/saveconteo/postmode`).replace("/index/noaud", "").replace("/counts/resumen_items", "");


    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            M.toast(
                {
                    html: `No se guardo el conteo del item ${itemcode}
                           Error encontrado ${error}`,
                    classes: 'rounded red lighten-1'
                }
            );
        })
        .then(
            response => {
                console.log(response);
                if (response === 'ERROR') {
                    M.toast(
                        {
                            html: `No se guardo el conteo del item ${itemcode}`,
                            classes: 'rounded red lighten-1'
                        }
                    );
                }
                else {
                    if (response === 'OK') {
                        M.toast(
                            {
                                html: `Se guardo el conteo del item ${itemcode}`,
                                classes: 'rounded green lighten-1'
                            }
                        );
                        drawSaveItem(cod_new_ubicacion, true);

                    }
                    else {
                        M.toast(
                            {
                                html: `No se guardo el conteo del item ${itemcode}`,
                                classes: 'rounded red lighten-1'
                            }
                        );

                        drawSaveItem(cod_new_ubicacion, false);
                    }
                }
            }
        );
};


const drawSaveItem = (id_item, isSaved) => {
    let draw_item = document.getElementById(id_item).parentElement.parentElement;
    if (isSaved == true)
        draw_item.setAttribute('class', ' teal lighten-2')
    else
        draw_item.setAttribute('class', '')
}

const downloadCSV = (csv, filename) => {
    var csvFile;
    var downloadLink;

    // CSV file
    csvFile = new Blob([csv], {type: "text/csv"});

    // Download link
    downloadLink = document.createElement("a");

    // File name
    downloadLink.download = filename;

    // Create a link to the file
    downloadLink.href = window.URL.createObjectURL(csvFile);

    // Hide download link
    downloadLink.style.display = "none";

    // Add the link to DOM
    document.body.appendChild(downloadLink);

    // Click download link
    downloadLink.click();
}


const exportTableToCSV = (filename) => {
    var csv = [];
    var rows = document.querySelectorAll("table tr");

    for (var i = 0; i < rows.length; i++) {
        var row = [], cols = rows[i].querySelectorAll("td, th");

        for (var j = 0; j < cols.length; j++)
            row.push(cols[j].innerText);

        csv.push(row.join(";"));
    }

    // Download CSV file
    downloadCSV(csv.join("\n"), filename);
}


const addItemForMI = async (conteo, BUSCAR_MAESTRO_OPEN, url) => {

    const productos = await getDataProductsFetch2(conteo, BUSCAR_MAESTRO_OPEN, url);
    const contenedorTable = document.getElementById("content-table");

    if (productos != null) {
        const tabla = DrawDataInsert(productos);
        const contenedorTable = document.getElementById("content-table");
        contenedorTable.innerHTML = tabla;
    }
};


const getCountForTipoSearch = () => {
    const auditoria = document.getElementById("inp_cod_auditoria");
    const bodega = (document.getElementById("inp_cod_bodega"));
    const grupo = (document.getElementById("inp_cod_group"));
    const ubicI = (document.getElementById("inp_cod_ubicacion_i"));
    const ubicF = (document.getElementById("inp_cod_ubicacion_f"));
    const conteocode = (document.getElementById("inp_cod_count"));
    const product = (document.getElementById("inp_cod_product"));


    if ((auditoria.value === null || auditoria.value.length < 1 || auditoria.value.trim().length < 1) && auditoria.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe inresar un codigo de auditoria', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((bodega.value === null || bodega.value.length < 1 || bodega.value.trim().length < 1) && bodega.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe Ingresar un codigo de bodega', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((grupo.value.length < 1 || grupo.value.trim().length < 1 || grupo.value === null) && (grupo.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar su codigo de grupo', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((conteocode.value === null || conteocode.value.length < 1 || conteocode.value.trim().length < 1) && (conteocode.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar en codigo de su conteo C001, C002, C003', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((ubicI.value === null || ubicI.value.length < 1 || ubicI.value.trim().length < 1) && (ubicI.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar la ubicacion inicial', classes: 'rounded red lighten-1'});
        return {};
    }


    if ((ubicF.value === null || ubicF.value.length < 1 || ubicF.value.trim().length < 1) && (ubicF.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar la ubicacion final', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((product.value === null || product.value.length < 1 || product.value.trim().length < 1) && (product.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar el codigo de productos', classes: 'rounded red lighten-1'});
        return {};
    }


    const tieneT = auditoria.value.indexOf("*");

    const conteo = {
        auditoria: `${quitarAll(auditoria.value)}`,
        bodega: `${bodega.value}`,
        grupo: `${grupo.value}`,
        conteocode: `${conteocode.value}`,
        ubicacion: `${ubicI.value}`,
        codigo: `${product.value}`,
        observacion: `${ubicF.value}`
    };

    return conteo;

}


const DrawDataInsert = (data) => {
    console.log(data);
    const auditoria = (document.getElementById("inp_cod_auditoria")).value;
    const bodega = (document.getElementById("inp_cod_bodega")).value;
    const grupo = (document.getElementById("inp_cod_group")).value;
    const ubicI = (document.getElementById("inp_cod_ubicacion_i")).value;
    const ubicF = (document.getElementById("inp_cod_ubicacion_f")).value;
    const conteo = (document.getElementById("inp_cod_count")).value;
    const contenedorTable = document.getElementById("content-table");


    let tabla = `
        <table class="responsive-table striped">
            <thead>
                <tr>
                    <th>Ubicacion</th>
                    <th>Cod. Item</th>
                    <th>Descripcion</th>             
                    <th>Acciones</th>   
                </tr>
            </thead>
            <tbody>
        `;

    data.forEach(
        dato => {
            tabla += `
                <tr>
                    <td><input id="ubicacion_${bodega}${dato.codigo}" type="text" value=""></td>
                    <td id="itemcode_${bodega}${dato.codigo}">${validarNulos(dato.codigo)}</td>
                    <td id="descripcion_${bodega}${dato.codigo}">${validarNulos(dato.descripcion)}</td>
                    <td><i class="material-icons" onclick="saveItemPost('${auditoria}','${bodega}','ubicacion_${bodega}${dato.codigo}','itemcode_${bodega}${dato.codigo}', 'descripcion_${bodega}${dato.codigo}',${dato.cantidad}, ${dato.costounitario}, '${dato.familia}')">send</i></td>
                </tr>
                `;
        });

    tabla += ` </tbody></table> `;
    return tabla;
}


const saveItemPost = async (auditoria, bodega, ubicacion_id, codigo_id, descripcion_total_id, cantidad, costounitario, familia) => {

    const codigo = (document.getElementById(`${codigo_id}`)).innerText;
    const descripcion_total = (document.getElementById(`${descripcion_total_id}`)).innerText;
    const ubicacion = (document.getElementById(`${ubicacion_id}`)).value;
    const grupo = (document.getElementById("inp_cod_group")).value;
    const codconteo = (document.getElementById("inp_cod_count")).value;


    if ((ubicacion === null || ubicacion.trim().length < 1)) {
        M.toast(
            {
                html: `El item ${codigo} no tiene ubicacion
                Ingresela en la observacion`,
                classes: 'rounded red lighten-1'
            }
        );
        return;
    }


    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    const conteo = {
        auditoria: `${auditoria}`,
        bodega: `${bodega}`,
        ubicacion: `${ubicacion}`,
        codigo: `${codigo}`,
        descripcion: `${quitarCaracteres(descripcion_total, null)}`,
        cantidad: `${cantidad}`,
        costounitario: `${costounitario}`,
        familia: `${familia}`,
        conteocode: `${codconteo}`,
        grupoc1: `${grupo}`,
        grupo: `G000`
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(conteo)
    };


    // const url =  `http://localhost:8080/product/saveconteo/postmode`;
    const url = getParamName(`${ambienteruta()}product/saveitem/postmode`).replace("/index/noaud", "").replace("/counts/resumen_items", "");


    await fetch(url, MyConfig)
        .then(response => {
            return response.json();
        })
        .catch(error => {
            M.toast(
                {
                    html: `No se guardo el conteo del item ${codigo}
                           Error encontrado ${error}`,
                    classes: 'rounded red lighten-1'
                }
            );
        })
        .then(
            response => {
                console.log(response);
                if (response === 'ERROR') {
                    M.toast(
                        {
                            html: `No se guardo el conteo del item ${codigo}`,
                            classes: 'rounded red lighten-1'
                        }
                    );
                }
                else {
                    if (response === 'OK') {
                        M.toast(
                            {
                                html: `Se guardo el conteo del item ${codigo}`,
                                classes: 'rounded green lighten-1'
                            }
                        );
                    }
                    else {
                        M.toast(
                            {
                                html: `No se guardo el conteo del item ${codigo}`,
                                classes: 'rounded red lighten-1'
                            }
                        );
                    }
                }
            }
        );
};