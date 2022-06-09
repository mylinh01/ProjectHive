var rownum = 0;
var yline;

function loadFile(){ with (new XMLHttpRequest()) {
    onreadystatechange=cb; open('GET','/data1',true); responseType='text';send();
}}

var loadFile = setInterval(loadFile, 5000);

function cb(){
    if(this.readyState===4) tbl(this.responseText);
}

function tbl(csv) {
    let arrResult = JSON.parse(csv);

    // [id,name,sl, dm]
    let s ="<table>\n" +
        "        <tr>\n" +
        "            <th>vid_id</th>\n" +
        "            <th>uploader_name</th>\n" +
        "            <th>interval_from_created_to_upload</th>\n" +
        "            <th>category</th>\n" +
        "            <th>video_length</th>\n" +
        "            <th>no_of_views</th>\n" +
        "            <th>ratings</th>\n" +
        "            <th>no_of_ratings</th>\n" +
        "            <th>no_of_comments</th>\n" ;

    arrResult.forEach((data,index)=>{
        s = s + " <tr> ";
        data.forEach((dt)=>{
            s = s + ` <td> ${dt}</td> `;
        })
        s= s+ " </tr> "
    })

    s = s + "</table>";
    var ctx = document.getElementById('canvas2');
    ctx.innerHTML = s;

}
document.getElementById('stopDataset').addEventListener('click', function() {
    alert('Stop Adding Dataset...');
    clearInterval(loadFile);
});
