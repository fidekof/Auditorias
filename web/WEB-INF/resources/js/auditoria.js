const AuditoriaRegistrarv = async  auditoria => {
    const header = new Headers();
    header.append('Content-Type', 'aplication/json')
    const myInit = {
        method: 'POST',
        headers: header,
        body: JSON.stringify(auditoria)
    };

    const resp = await fetch(apiAuditoria, myInit);
    const json = await  resp.json();
    console.log(json);
}


