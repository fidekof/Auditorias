const
    caracteres_especiales = '"&\'*#';

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
