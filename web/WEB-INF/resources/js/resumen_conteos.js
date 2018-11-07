const BUSCAR_TODO = 1;
const BUSCAR_POR_ITEM = 2;
const BUSCA_UBICACION = 3;
const BUSCAR_RANGO_UBUCACIONES = 4;
const BUSCAR_MAESTRO_OPEN = 5;

// VALOR DE LOS INPUTS
let div_inp_cod_bodega;
let div_inp_cod_auditoria;
let div_inp_cod_group;
let dvi_inp_cod_count;
let div_inp_cod_ubicacion_i;
let div_inp_cod_ubicacion_f;
let div_inp_cod_product;
let GLOBAL_TYPE_SEARCH = 1;


let but_search_items_no_aud = document.getElementById("but_search_items_no_aud");
let select_search_id = document.getElementById("select_search_id");
let instance_select_search_id;


const mostrarTodosLosFiltros = () => {
    div_inp_cod_bodega.style.display = 'initial';
    div_inp_cod_auditoria.style.display = 'initial';
    div_inp_cod_group.style.display = 'initial';
    dvi_inp_cod_count.style.display = 'initial';
    div_inp_cod_ubicacion_i.style.display = 'initial';
    div_inp_cod_ubicacion_f.style.display = 'initial';
    div_inp_cod_product.style.display = 'initial';

}

const mostrarOcultarOpcionesDeBusqueda = (value) => {

    // mostrarTodosLosFiltros();
    if (!value) {
        M.toast(
            {
                html: `Debe seleccionar un metodo de busqueda`,
                classes: 'rounded red lighten-1'
            }
        );
    }
    else {
        try {


            const valor = parseInt(value);
            GLOBAL_TYPE_SEARCH = valor;
            if (valor !== null) {

                switch (valor) {
                    case BUSCAR_TODO: {
                        div_inp_cod_ubicacion_i.style.display = 'none';
                        div_inp_cod_ubicacion_f.style.display = 'none';
                        div_inp_cod_product.style.display = 'none';
                        break;
                    }

                    case BUSCAR_POR_ITEM: {
                        div_inp_cod_ubicacion_i.style.display = 'none';
                        div_inp_cod_ubicacion_f.style.display = 'none';

                        break;
                    }

                    case BUSCA_UBICACION: {
                        div_inp_cod_ubicacion_f.style.display = 'none';
                        div_inp_cod_product.style.display = 'none';
                        break;
                    }

                    case BUSCAR_RANGO_UBUCACIONES: {
                        div_inp_cod_product.style.display = 'none';
                        break;
                    }

                }
            }
        } catch (e) {
            M.toast(
                {
                    html: `Error en seleccion de tipo busqueda: ${e.message}`,
                    classes: 'rounded red lighten-1'
                }
            );
        }
    }
}


document.addEventListener('DOMContentLoaded', () => {
    let elems = document.querySelectorAll('select');
    let instances = M.FormSelect.init(elems, {
        alignment: 'right',
        closeOnClick: true
    });

    //------------------------------------------------------------------------------------------

    div_inp_cod_bodega = document.getElementById("div_inp_cod_bodega");
    div_inp_cod_auditoria = document.getElementById("div_inp_cod_auditoria");
    div_inp_cod_group = document.getElementById("div_inp_cod_group");
    dvi_inp_cod_count = document.getElementById("dvi_inp_cod_count");
    div_inp_cod_ubicacion_i = document.getElementById("div_inp_cod_ubicacion_i");
    div_inp_cod_ubicacion_f = document.getElementById("div_inp_cod_ubicacion_f");
    div_inp_cod_product = document.getElementById("div_inp_cod_product");

    //------------------------------------------------------------------------------------------

    but_search_items_no_aud = document.getElementById("but_search_items_no_aud");

    //------------------------------------------------------------------------------------------
    select_search_id = document.getElementById("select_search_id");


    let pushpin = document.querySelectorAll('.pushpin');
    let instances_pushpin = M.Pushpin.init(pushpin, {});

    select_search_id.addEventListener("change", (event) => {
        if (!event.target.value) {
            M.toast(
                {
                    html: `Debe seleccionar un metodo de busqueda`,
                    classes: 'rounded red lighten-1'
                }
            );
        }
        else {
            mostrarOcultarOpcionesDeBusqueda(event.target.value);
        }
    });

    but_search_items_no_aud.addEventListener("click", () => {
        searchResumenCounts('N')
    });

});


const searchResumenCounts = async (typeAud) => {

    // const productos = await getDataProducts();
    const productos = await getDataResumenProductsFetch();

    DrawResumenCouns(productos, typeAud);

};


const DrawResumenCouns = (data, typeAud) => {
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
        let tabla = ``;
        tabla = tablaResumenConteoPorcetual2(data);
        contenedorTable.innerHTML = tabla;
    }
};

const calcularTotales = (data) => {
    let result = {
        total_idproducto: 0,
        total_diferencia1: 0,
        total_stock_contado: 0,
        total_precio_stock: 0,
        total_precio_contado: 0
    };
    if (data != null && data.length > 0) {
        data.forEach(dato => {
            result.total_idproducto += parseFloat(dato.idproducto);
            result.total_diferencia1 += parseFloat(dato.diferencia1);
            result.total_stock_contado += parseFloat(dato.conteo1);
            result.total_precio_stock += parseFloat(dato.costounitario);
            result.total_precio_contado += parseFloat(dato.conteo2);
        });
    }

    return result;
}


const tablaResumenConteoPorcetual = (data) => {
    console.log(data);
    const valores_totales = calcularTotales(data);
    let tabla = `
        <table class="striped">
        <caption>Resumen de conteo <a id="img_file_download" onclick="exportTableToCSV('auditoria.csv')" class="waves-effect waves-light btn-small light-blue darken-4"><i  class="material-icons left">file_download</i></a></caption>
            <thead>
                <tr>
                    <td>Cod. Aud</td>
                    <td>Bodega</td>
                    <td>Grupo</td>
                    <td>Ubi. Contada</td>
                    <td>% Av.</td>
                    <td>Stock Sistema</td>
                    <td>Costo Sistema</td>
                    <td>Stock Contado</td>   
                    <td>Costo Contado</td>
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
                   <td>${validarNulos(dato.grupoc1)}</td>
                   <td>${validarNulos(dato.ubicacion)}</td>
                   <td>${((parseFloat(dato.ubicacion) * 100) / valores_totales.total_ubicaciones).toFixed(0)}%</td>  
                   <td>${validarNulos(parseFloat(dato.cantidad).toFixed(0))}</td>                                      
                   <td>$ ${validarNulos(parseFloat(dato.costounitario).toFixed(0))}</td>  
                   <td>${validarNulos(parseFloat(dato.conteo1).toFixed(3))}</td>  
                   <td>$ ${validarNulos(parseFloat(dato.conteo2).toFixed(3))}</td>   
                </tr>
            `;
        });


    tabla += `
                <tr>
                   <td colspan="3">Tolal: </td>
                   <td>${valores_totales.total_ubicaciones}</td>
                   <td>${((parseFloat(valores_totales.total_stock) * 100) / valores_totales.total_stock).toFixed(3)}%</td>  
                   <td>${validarNulos(parseFloat(valores_totales.total_stock).toFixed(3))}</td>                                      
                   <td>$ ${validarNulos(parseFloat(valores_totales.total_precio_stock).toFixed(3))}</td>  
                   <td>${validarNulos(parseFloat(valores_totales.total_stock_contado).toFixed(3))}</td>  
                   <td>$ ${validarNulos(parseFloat(valores_totales.total_precio_contado).toFixed(3))}</td>   
                </tr>
            `;


    tabla += ` </tbody></table> `;
    return tabla;
};


const getClassForTr = (flag) => {
    return (flag === true) ? 'class="blue lighten-4"' : '';
}
const tablaResumenConteoPorcetual2 = (data) => {
    console.log(data);
    const valores_totales = calcularTotales(data);
    let tabla = `
        <table class="striped">
        <caption>Resumen de conteo <a id="img_file_download" onclick="exportTableToCSV('auditoria.csv')" class="waves-effect waves-light btn-small light-blue darken-4"><i  class="material-icons left">file_download</i></a></caption>
            <thead>
                <tr>
                    
                    <td>Grupo</td>
                    <td>Items con stock</td>
                    <td>Contadas</td>
                    <td>Faltantes</td>
                    <td>Porcentaje</td>
                   
                
                </tr>
            </thead>
            <tbody>
        `;
    let flag = true;
    data.forEach(
        dato => {
            tabla += `
                <tr ${getClassForTr(flag)}>
                       
                   <td>${(validarNulos(dato.grupoc1).trim() === 'G000') ? '<b>SIN ASIGNACION</b>' : validarNulos(dato.grupoc1)}</td>
                   <td>${validarNulos(parseFloat(dato.idproducto).toFixed(0))}</td>
                   <td>${validarNulos(parseFloat(dato.diferencia1).toFixed(0))}</td>  
                   <td>${validarNulos(parseFloat(dato.idproducto).toFixed(0) - parseFloat(dato.diferencia1).toFixed(0))}</td>  
                   <td>${((parseFloat(dato.diferencia1) * 100) / parseFloat(dato.idproducto)).toFixed(3)}%</td>  
                 
                </tr>
            `;
            flag = !flag;
        });


    tabla += `
                <tr class="tr_resumen_total">
                   <td class="td_resumen_total">Tolal: </td>
                   <td class="td_resumen_total">${valores_totales.total_idproducto}</td>
                   <td class="td_resumen_total">${valores_totales.total_diferencia1}</td>  
                   <td class="td_resumen_total">${valores_totales.total_idproducto - valores_totales.total_diferencia1}</td>  
                   <td class="td_resumen_total">${((parseFloat(valores_totales.total_diferencia1) * 100) / parseFloat(valores_totales.total_idproducto)).toFixed(3)}%</td>                                      
                </tr>
            `;


    tabla += ` </tbody></table> `;
    return tabla;
};


const getDataResumenProductsFetch = async () => {
    const auditoria = document.getElementById("inp_cod_auditoria");
    const bodega = (document.getElementById("inp_cod_bodega"));
    const grupo = (document.getElementById("inp_cod_group"));
    const ubicI = (document.getElementById("inp_cod_ubicacion_i"));
    const ubicF = (document.getElementById("inp_cod_ubicacion_f"));
    const conteocode = (document.getElementById("inp_cod_count"));
    const product = (document.getElementById("inp_cod_product"));
    // const tipoBusqueda = select_search_id.value;
    const tipoBusqueda = BUSCAR_TODO;


    if ((auditoria.value === null || auditoria.value.length < 1 || auditoria.value.trim().length < 1) && auditoria.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe inresar un codigo de auditoria', classes: 'rounded red lighten-1'});
        return {};
    }

    if ((bodega.value === null || bodega.value.length < 1 || bodega.value.trim().length < 1) && bodega.parentNode.style.display !== 'none') {
        M.toast({html: 'Debe Ingresar un codigo de bodega', classes: 'rounded red lighten-1'});
        return {};
    }

    //
    // if ((grupo.value.length < 1 || grupo.value.trim().length < 1 || grupo.value === null) && (grupo.parentNode.style.display !== 'none')) {
    //     M.toast({html: 'Debe Ingresar su codigo de grupo', classes: 'rounded red lighten-1'});
    //     return {};
    // }


    if ((conteocode.value === null || conteocode.value.length < 1 || conteocode.value.trim().length < 1) && (conteocode.parentNode.style.display !== 'none')) {
        M.toast({html: 'Debe Ingresar en codigo de su conteo C001, C002, C003', classes: 'rounded red lighten-1'});
        return {};
    }

    // if ((ubicI.value === null || ubicI.value.length < 1 || ubicI.value.trim().length < 1) && (ubicI.parentNode.style.display !== 'none')) {
    //     M.toast({html: 'Debe Ingresar la ubicacion inicial', classes: 'rounded red lighten-1'});
    //     return {};
    // }
    //
    //
    // if ((ubicF.value === null || ubicF.value.length < 1 || ubicF.value.trim().length < 1) && (ubicF.parentNode.style.display !== 'none')) {
    //     M.toast({html: 'Debe Ingresar la ubicacion final', classes: 'rounded red lighten-1'});
    //     return {};
    // }
    //
    // if ((product.value === null || product.value.length < 1 || product.value.trim().length < 1) && (product.parentNode.style.display !== 'none')) {
    //     M.toast({html: 'Debe Ingresar el codigo de productos', classes: 'rounded red lighten-1'});
    //     return {};
    // }

    const url = getParamName(`${ambienteruta()}product/resumen/${tipoBusqueda}`).replace("/counts/resumen_conteo", "").replace("/counts/resumen_conteo", "");


    const myHeaders = new Headers();
    myHeaders.append('Accept', 'application/json');
    myHeaders.append('Content-Type', 'application/json');

    // const conteo = {
    //     auditoria: `${quitarAll(auditoria.value)}`,
    //     bodega: `${bodega.value}`,
    //     grupo: `${grupo.value}`,
    //     conteocode: `${conteocode.value}`,
    //     ubicacion: `${ubicI.value}`,
    //     codigo: `${product.value}`,
    //     observacion: `${ubicF.value}`
    // };


    const conteo = {
        auditoria: `${quitarAll(auditoria.value)}`,
        bodega: `${bodega.value}`,
        grupo: `G001`,
        conteocode: `${conteocode.value}`,
        ubicacion: `A`,
        codigo: `B`,
        observacion: `C}`
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