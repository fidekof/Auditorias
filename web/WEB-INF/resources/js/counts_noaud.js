const BUSCAR_TODO = 1;
const BUSCAR_POR_ITEM = 2;
const BUSCA_UBICACION = 3;
const BUSCAR_RANGO_UBUCACIONES = 4;

// VALOR DE LOS INPUTS
let div_inp_cod_bodega;
let div_inp_cod_auditoria;
let div_inp_cod_group;
let dvi_inp_cod_count;
let div_inp_cod_ubicacion_i;
let div_inp_cod_ubicacion_f;
let div_inp_cod_product;



let but_search_items_no_aud = document.getElementById("but_search_items_no_aud");
let img_search_item_id = document.getElementById("img_search_item_id");

let select_search_id = document.getElementById("select_search_id");
let instance_select_search_id;

but_search_items_no_aud.addEventListener("click", () => {
    searchProductsForCounts('N')
});
img_search_item_id.addEventListener("click", () => {
    searchItemsForCounts('N')
});


select_search_id.addEventListener("change", () => {
    const list_value = instance_select_search_id.getSelectedValues();
    mostrarOcultarOpcionesDeBusqueda(list_value[0]);
});


const mostrarTodosLosFiltros = () =>{
    div_inp_cod_bodega.style.display = 'initial';
    div_inp_cod_auditoria.style.display = 'initial';
    div_inp_cod_group.style.display = 'initial';
    dvi_inp_cod_count.style.display = 'initial';
    div_inp_cod_ubicacion_i.style.display = 'initial';
    div_inp_cod_ubicacion_f.style.display = 'initial';
    div_inp_cod_product.style.display = 'initial';

}

const mostrarOcultarOpcionesDeBusqueda = (valor) => {
    if (valor !== null) {

        switch (valor) {
            case BUSCAR_TODO: {
                div_inp_cod_ubicacion_i.style.display = 'none';
                div_inp_cod_ubicacion_f.style.display = 'none';
                div_inp_cod_product.style.display = 'none';
                break;
            }

            case BUSCAR_POR_ITEM: {
                break;
            }

            case BUSCA_UBICACION: {
                break;
            }

            case BUSCAR_RANGO_UBUCACIONES: {

                break;
            }

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
    img_search_item_id = document.getElementById("img_search_item_id");
    //------------------------------------------------------------------------------------------
    select_search_id = document.getElementById("select_search_id");
    instance_select_search_id = M.FormSelect.getInstance(select_search_id);
    instance_select_search_id.getSelectedValues()[0];
});
