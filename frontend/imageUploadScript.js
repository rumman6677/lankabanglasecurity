function uploadImage() {
    const form = document.getElementById('imageUploadForm');
    const formData = new FormData(form);
    const savedResponse = localStorage.getItem("responseKey");
    const apiUrl = `http://localhost:8080/${savedResponse}/upload`; // Modify the path as needed

    fetch(apiUrl, {
        method: 'POST',
        body: formData,
    })
    .then(response => response.text())
    .then(data => {
        const message = document.getElementById('message');
        message.textContent = data;
        message.style.color = 'green';
        form.reset();
    })
    .catch(error => {
        const message = document.getElementById('message');
        message.textContent = 'Error uploading image.';
        message.style.color = 'red';
    });
}


function uploadImageNid() {
    const form = document.getElementById('imageUploadFormNid');
    const formData = new FormData(form);
    const savedResponse = localStorage.getItem("responseKey");
    const apiUrl = `http://localhost:8080/${savedResponse}/upload/nid`; // Modify the path as needed

    fetch(apiUrl, {
        method: 'POST',
        body: formData,
    })
    .then(response => response.text())
    .then(data => {
        const message = document.getElementById('message');
        message.textContent = data;
        message.style.color = 'green';
        form.reset();
    })
    .catch(error => {
        const message = document.getElementById('message');
        message.textContent = 'Error uploading image.';
        message.style.color = 'red';
    });
}


function uploadImageutility() {
    const form = document.getElementById('imageUploadFormUtility');
    const formData = new FormData(form);
    const savedResponse = localStorage.getItem("responseKey");
    const apiUrl = `http://localhost:8080/${savedResponse}/upload/utility`; // Modify the path as needed

    fetch(apiUrl, {
        method: 'POST',
        body: formData,
    })
    .then(response => response.text())
    .then(data => {
        const message = document.getElementById('message');
        message.textContent = data;
        message.style.color = 'green';
        form.reset();
    })
    .catch(error => {
        const message = document.getElementById('message');
        message.textContent = 'Error uploading image.';
        message.style.color = 'red';
    });
}


function uploadImageetin() {
    const form = document.getElementById('imageUploadFormNid');
    const formData = new FormData(form);
    const savedResponse = localStorage.getItem("responseKey");
    const apiUrl = `http://localhost:8080/${savedResponse}/upload/etin`; // Modify the path as needed

    fetch(apiUrl, {
        method: 'POST',
        body: formData,
    })
    .then(response => response.text())
    .then(data => {
        const message = document.getElementById('message');
        message.textContent = data;
        message.style.color = 'green';
        form.reset();
    })
    .catch(error => {
        const message = document.getElementById('message');
        message.textContent = 'Error uploading image.';
        message.style.color = 'red';
    });
}