const btn_search_count = document.getElementById("but_search_items");
const img_search_item_id = document.getElementById("img_search_item_id");
img_search_item_id.addEventListener("click",()=>{searchItemsForCounts('Y')});
btn_search_count.addEventListener("click", ()=>{searchProductsForCounts('Y')});