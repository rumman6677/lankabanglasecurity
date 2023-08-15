const urlParams = new URLSearchParams(window.location.search);
const userId = urlParams.get('id');
const apiUrl = `http://localhost:8080/api/${userId}`;


const apiUrltoUpdate =`http://localhost:8080/api/update/status/${userId}`;

const profileInfo = document.querySelector('.profile-info');
const imagePreviews = document.querySelector('.image-previews');

fetch(apiUrl)
    .then(response => response.json())
    .then(userResponse => {
        const dateOfBirth = new Date(userResponse.dateOfBirth).toLocaleDateString();
        const accountDate = new Date(userResponse.accountDate).toLocaleDateString();

        profileInfo.innerHTML = profileInfo.innerHTML = `
        <div class="user-profile">
            <h2>User Profile: ${userResponse.boNo}</h2>
            <div class="flex-container">
                <div class="flex-item">
                    <p class="section-heading">Personal Information</p>
                    <p><span class="label">Account Number:</span> ${userResponse.accountNum}</p>
                    <p><span class="label">BO Number:</span> ${userResponse.boNo}</p>
                    <p><span class="label">Product Type:</span> ${userResponse.productType}</p>
                    <p><span class="label">Contact:</span> ${userResponse.contact}</p>
                    <p><span class="label">Account Date:</span> ${accountDate}</p>
                    <p><span class="label">Account Type: ${userResponse.accountType}</p>
                    <p><span class="label">Client Code: ${userResponse.clientCode}</p>
                    <p><span class="label">Link Code: ${userResponse.linkCode}</p>
                    <!-- Add more personal information fields as needed -->
                </div>
                <div class="flex-item">
                    <p class="section-heading">Personal Details</p>
                    <p><span class="label">Father's Name:</span> ${userResponse.fatherName}</p>
                    <p><span class="label">Mother's Name:</span> ${userResponse.motherName}</p>
                    <p><span class="label">Date of Birth:</span> ${dateOfBirth}</p>
                    <p><span class="label">Gender:</span> ${userResponse.gender}</p>
                    <p><span class="label">Nationality:</span> ${userResponse.nationality}</p>
                    <p><span class="label">Present Address: ${userResponse.prAddress}</p>
                    <p><span class="label">Phone Number: ${userResponse.phoneNumber}</p>
                    <p><span class="label">Telephone: ${userResponse.tel}</p>
                    <p><span class="label">Permanent Address: ${userResponse.pAddress}</p>
                    <p><span class="label">Email: ${userResponse.email}</p>
                    <p><span class="label">Occupation: ${userResponse.occupation}</p>
                    <!-- Add more personal details fields as needed -->
                </div>
                <div class="flex-item">
                <p class="section-heading">Bank Details</p>
                <p><span class="label">Bank Name: ${userResponse.bankName}</p>
                <p><span class="label">Branch Name: ${userResponse.branchName}</p>
                <p><span class="label">LSL Branch Name: ${userResponse.lslbranchName}</p>
                <!-- Add more personal details fields as needed -->
            </div>
                <!-- Add other sections using similar code -->
            </div>
        </div>
    `;

        const imageTitles = {
            photoId: "Photo ID",
            nid: "National ID",
            uid: "User ID",
            etinId: "ETIN ID"
        };

        for (const imageId in imageTitles) {
            const container = document.createElement('div');
            container.className = 'image-container';

            const title = document.createElement('p');
            title.textContent = imageTitles[imageId];
            container.appendChild(title);

            const imagePreview = document.createElement('img');
            imagePreview.src = `http://localhost:8080/image/${userResponse[imageId]}`;
            imagePreview.alt = `Image ${imageTitles[imageId]}`;
            container.appendChild(imagePreview);

            imagePreviews.appendChild(container);
        }
    })
    .catch(error => {
        console.error('Error fetching user data:', error);
    });



const apiButton = document.getElementById('apiButton');
const messageDiv = document.getElementById('message');

    apiButton.addEventListener('click', () => {
            // Perform the API call here
            fetch(apiUrltoUpdate)
                .then(response => response.json())
                .then(data => {
                    // Handle the API response data
                    messageDiv.textContent = 'API call successful: ' + JSON.stringify(data);
                    messageDiv.style.color = 'green';
                })
                .catch(error => {
                    // Handle API call error
                    messageDiv.textContent = 'API call failed.';
                    messageDiv.style.color = 'red';
                });
        });
