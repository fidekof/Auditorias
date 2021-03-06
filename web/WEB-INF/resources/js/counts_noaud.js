const BUSCAR_TODO = 1;
const BUSCAR_POR_ITEM = 2;
const BUSCA_UBICACION = 3;
const BUSCAR_RANGO_UBUCACIONES = 4;
const BUSCAR_MAESTRO_OPEN = 5;
const BUSCAR_MAESTRO_UBICACIONES = 7;
const BUSCAR_NO_CONTADAS = 8;
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

    mostrarTodosLosFiltros();
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

                    case BUSCAR_NO_CONTADAS: {
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
        searchProductsForCounts('N')
    });


    const button_add = document.getElementById('img_add_item_id');
    button_add.addEventListener('click', () => {
        const itemcode = (document.getElementById("inp_cod_product")).value;
        const conteo = getCountForTipoSearch();
        const url = getParamName(`${ambienteruta()}product/auditoria/${BUSCAR_MAESTRO_OPEN}`).replace("/index/noaud", "").replace("/index/aud", "");
        if (itemcode != null && itemcode.trim().length > 0) {
            addItemForMI(conteo, BUSCAR_MAESTRO_OPEN, url);
        }
        else {
            M.toast(
                {
                    html: `El codigo de item Ingresado no es invalido`,
                    classes: 'rounded red lighten-1'
                }
            );
        }
    })

});
