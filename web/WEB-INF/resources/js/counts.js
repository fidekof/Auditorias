const produccion = false;


const ambienteruta = () =>{
    let result = "";
    if(produccion === true){result = "auditorias/"}
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

    const url = getParamName(`${ambienteruta()}product/byBodegaAndCode/${bodega}/${product}/${quitarAll(auditoria)}`).replace("/index/noaud","");
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


const quitarAll = (valor)=>{
    let result = "";
    if(valor !== null){result = valor.replace("*","");}
    return result;
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
    if(tieneT<0){

        //url = `http://localhost:8080/product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`;

          url = getParamName(`${ambienteruta()}product/byBodegaAndUbicacion/${bodega}/${ubicI}/${ubicF}/${quitarAll(auditoria)}`)
    }
    else {
          // url = `http://localhost:8080/product/byBodega/${bodega}/${quitarAll(auditoria)}`;

          url = getParamName(`${ambienteruta()}product/byBodega/${bodega}/${quitarAll(auditoria)}`);
    }
    url = url.replace("/index/noaud","");
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
        if (tieneT < 0) {tabla = tablaConteos(data, typeAud, auditoria,grupo,conteo);}
        else {tabla = tablaResumenConteo(data);}

        contenedorTable.innerHTML = tabla;
    }
};


const tablaResumenConteo = (data) => {
    let tabla = `
        <table class="responsive-table highlight">
        <caption>Resumen de conteo <a id="img_file_download" onclick="exportTableToCSV('auditoria.csv')" class="waves-effect waves-light btn-small light-blue darken-4"><i  class="material-icons left">file_download</i></a></caption>
            <thead>
                <tr>
                    <td>Cod. Aud</td>
                    <td>Bodega</td>
                    <td>Grupo</td>
                    <td>Ubicacion</td>
                    <td>Item Cod.</td>
                    <td>Descripcion</td>
                    <td>Cantidad</td>
                    <td>Costo U.</td>
                    <td>Conteo 1</td>                    
                    <td>Diferencia 1</td>
                    <td>Conteo 2</td>
                    <td>Diferencia 2</td>
                    <td>Conteo 3</td>
                    <td>Diferencia 3</td>
                    <td>Observacion</td>
                </tr>
            </thead>
            <tbody>
        `;

    data.forEach(
        dato => {
            tabla += `
                <tr>
                   <td>${validarNulos(dato.auditoria)}</td>
                   <td>${validarNulos(dato.bodega)}</td>            
                   <td>${validarNulos(dato.grupo)}</td>
                   <td>${validarNulos(dato.ubicacion)}</td>
                   <td>${validarNulos(dato.codigo)}</td>
                   <td>${validarNulos(dato.descripcion)}</td>   
                   <td>${validarNulos(dato.cantidad)}</td>
                   <td>${validarNulos(dato.costounitario)}</td>     
                   <td>${validarNulos(dato.conteo1)}</td>  
                   <td>${validarNulos(dato.diferencia1)}</td>  
                   <td>${validarNulos(dato.conteo2)}</td>  
                   <td>${validarNulos(dato.diferencia2)}</td>  
                   <td>${validarNulos(dato.conteo3)}</td>  
                   <td>${validarNulos(dato.diferencia3)}</td>  
                   <td>${validarNulos(dato.observacion)}</td>   
                </tr>
            `;
        });
    return tabla;
};




const tablaConteos = (data, typeAud, auditoria, grupo, conteo) => {
    let tabla = `
        <table class="responsive-table striped">
            <thead>
                <tr>
                    <th>Cod. Bodega</th>
                    <th>Ubicacion</th>
                    <th>Cod. Item</th>
                    <th>Descripcion</th>`;
    if (typeAud === 'Y') {
        tabla += `<th> Cantidad </th>`;
    }

    tabla += `      <th>Costo U.</th>
                    <th style="display: none">Familia</th> 
                    <th>Observacion</th>
                    <th>Conteo Actual</th>
                    <th>Acciones</th>
                    
                    
                </tr>
            </thead>
            <tbody>
        `;

    data.forEach(
        dato => {
            const valor_contado = obtenerValorConteo(dato,conteo);
            let imprimir = true;
            if(conteo.toUpperCase()==='C002' && (dato.cantidad - dato.conteo1)=== 0 ){ifimprimir = false;}
            else {
                if(conteo.toUpperCase()==='C003')
                {
                    if((dato.cantidad - dato.conteo1) !== 0 && (dato.cantidad - dato.conteo2) !== 0 && (dato.conteo1 - dato.conteo2) === 0){ifimprimir = false;}
                }
            }

            if(imprimir===true) {
                tabla += `
                <tr>
                    <td>${validarNulos(dato.bodega)}</td>
                    <td>${validarNulos(dato.ubicacion)}</td>
                    <td>${validarNulos(dato.codigo)}</td>
                    <td>${validarNulos(dato.descripcion)}</td>`;

                if (typeAud === 'Y') {
                    tabla += `<td>${validarNulos(dato.cantidad)}</td>`;
                }
                tabla += `
                    <td>${validarNulos(dato.costounitario)}</td>
                    <th style="display: none">${validarNulos(dato.familia)}</th> 
                    <td><input id="observacion_${dato.bodega}${dato.ubicacion}${dato.codigo}${dato.cantidad}" type="text" value="${validarNulos(dato.observacion)}"></td>                    
                    <td><input id="${dato.bodega}${dato.ubicacion}${dato.codigo}${dato.cantidad}" type="text" value="${validarNulos(valor_contado)}"></td>
                    <td>
                        <i class="material-icons" onclick="saveCountPost('${quitarAll(auditoria)}', '${grupo}', '${conteo}', '${dato.bodega}','${dato.ubicacion}','${dato.codigo}','${dato.cantidad}', '${dato.bodega}${dato.ubicacion}${dato.codigo}${dato.cantidad}', '${dato.descripcion}','${dato.costounitario}', '${dato.familia}', 'observacion_${dato.bodega}${dato.ubicacion}${dato.codigo}${dato.cantidad}')">save</i></td>
                </tr>
                `;
            }
        });


    return tabla;
};

const searchProductsForCounts = async (typeAud) => {

    const productos = await getDataProducts();
    if (productos !== null && productos.length > 0) {
        DrawCountsData(productos, typeAud);
    }
};


const obtenerValorConteo = (dato, conteoCode) =>
{
    let result = "";
    if(conteoCode!==null && dato!=null)
    {
        if(conteoCode ==="C001"){result = dato.conteo1;}
        else{
            if(conteoCode ==="C002"){result = dato.conteo2;}
            else{
                if(conteoCode ==="C003"){result = dato.conteo3;}
            }
        }

    }
    return result;
}


const validarNulos = cadena =>{
    return cadena !== null ? cadena : " ";
};

const saveCount = async (codigoAuditoria, codigoGrupo, codConteo, bodega, ubicacion, itemcode, valorInicial, idValorContado, descripcion) => {
    descripcion = descripcion.replace("/","_");
    const valorConteo =  (document.getElementById(`${idValorContado}`)).value;

    // const url =  `http://localhost:8080/product/saveconteo/${codigoAuditoria}/${codigoGrupo}/${codConteo}/${bodega}/${ubicacion}/${itemcode}/${valorInicial}/${valorConteo}/${descripcion}`;
    const url =  getParamName(`${ambienteruta()}product/saveconteo/${codigoAuditoria}/${codigoGrupo}/${codConteo}/${bodega}/${ubicacion}/${itemcode}/${valorInicial}/${valorConteo}/${descripcion}`).replace("/index/noaud","");


    const request = {method: 'GET', url: url};
    const response = await ajax(request);
    switch (response.status) {
        case 200: {
            const respuesta = response.responseText;
            if(respuesta.replace("\"","").replace("\"","") === 'OK'){
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
    if (productos !== null && productos.length > 0) {
        DrawCountsData(productos, typeAud);
    }
};



const saveCountPost = async (auditoria, grupo, conteocode, bodega, ubicacion, itemcode, cantidad, codconteo1, descripcion, costounitario, familia, codobservacion) => {
    // descripcion = descripcion.replace("/","_");
    const observacionI =  (document.getElementById(`${codobservacion}`)).value;
    const conteo1 =  (document.getElementById(`${codconteo1}`)).value;
    const diferencia1 = parseFloat(cantidad) - parseFloat(conteo1);



    descripcion = (descripcion !== null) ? (descripcion.replace("/", "_").replace("&", " ").replace("(", "_").replace(")", "_")) : "";
    const observacion = (observacionI !== null) ? (observacionI.replace("/", "_").replace("&", " ").replace("(", "_").replace(")", "_")) : "";

    if((ubicacion===null || ubicacion.trim().length<1) && (observacion===null || observacion.trim().length<1))
    {
        M.toast(
            {
                html: `El item ${itemcode} no tiene ubicacion
                Ingresela en la observacion`,
                classes: 'rounded red lighten-1'
            }
        );

        return;

    }
    else{ubicacion=observacion}

    const myHeaders =  new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type','application/json');

    const conteo = {
        auditoria: `${quitarAll(auditoria)}`,
        bodega : `${bodega}`,
        grupo: `${grupo}`,
        conteocode : `${conteocode}`,
        ubicacion : `${ubicacion}`,
        codigo : `${itemcode}`,
        descripcion : `${descripcion}`,
        cantidad : `${cantidad}`,
        conteo1 : `${conteo1}`,
        diferencia1: `${diferencia1}`,
        costounitario: `${costounitario}` ,
        familia: `${familia}` ,
        observacion: `${observacion}`
    };

    const MyConfig = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(conteo)
    };


    // const url =  `http://localhost:8080/product/saveconteo/postmode`;
    const url =  getParamName(`${ambienteruta()}product/saveconteo/postmode`).replace("/index/noaud","");


    await fetch(url,MyConfig)
        .then( response =>{ return response.json();})
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
                    if(response === 'ERROR')
                    {
                        M.toast(
                            {
                                html: `No se guardo el conteo del item ${itemcode}`,
                                classes: 'rounded red lighten-1'
                            }
                        );
                    }
                    else
                        {
                            if(response === 'OK')
                            {
                                M.toast(
                                    {
                                        html: `Se guardo el conteo del item ${itemcode}`,
                                        classes: 'rounded green lighten-1'
                                    }
                                );
                            }
                            else
                            {
                                M.toast(
                                    {
                                        html: `No se guardo el conteo del item ${itemcode}`,
                                        classes: 'rounded red lighten-1'
                                    }
                                );
                            }
                        }
                }
            );
};



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



const exportTableToCSV = (filename) =>{
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


