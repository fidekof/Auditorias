const but_search_items_no_aud = document.getElementById("but_search_items_no_aud");
const img_search_item_id = document.getElementById("img_search_item_id");
but_search_items_no_aud.addEventListener("click",()=>
{

    searchProductsForCounts('N')
});
img_search_item_id.addEventListener("click",()=>{searchItemsForCounts('N')});