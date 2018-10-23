const btn_searchr_user = document.getElementById("btn_user");
btn_searchr_user.addEventListener("click", () => {
    searchUserjde('Y')
});
/*
function ert() {
    const contenedor2= document.getElementById("container2");
    contenedor2.innerHTML = ``;
    let tabla = `
            <div class="signup">
              <form>
                 <h4>Información</h4>`;



            tabla += `
                    
            <input type='text'  id="ced" maxlength="11" placeholder='Cédula:' value="0989897676"/>
            <input type='text'  id="longname" placeholder='Nombres:' value="Edison Cuadros" />
            <div class="select">
                <select id="perfil">
                    <option value="999">Perfil:</option>
                    <option value="A">Administrador</option>
                    <option value="0">Operativo</option>
                    <option value="S">Supervisor</option>
                </select>
            </div>
            <input type='text'  id="cod_jde" placeholder='Cod.jde:' value="434343" />
            <input type='submit' placeholder='Registrar' id="btn_save" value="Registrar" />
        </form>
    </div>
                `;


    contenedor2.innerHTML = tabla;
}

const btn_save = document.getElementById("btn_save");
btn_save.addEventListener("click", ()=>{saveUserjde('Y')});*/