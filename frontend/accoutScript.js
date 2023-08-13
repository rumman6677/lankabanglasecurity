const form = document.getElementById("accountForm");
form.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    // Get form data using FormData
    const formData = new FormData(form);

    // Create a JavaScript object to hold the form data
    const accountDto = {
        accountNum: formData.get("accountNum"),
        boNo: formData.get("boNo"),
        productType: formData.get("productType"),
        name: formData.get("name"),
        contact: formData.get("contact"),
        accountDate: formData.get("accountDate"),
        accountType: formData.get("accountType"),
        clientCode: formData.get("clientCode"),
        linkCode: formData.get("linkCode"),
        accountHolderName: formData.get("name"),
        fatherName: formData.get("fatherName"),
        motherName: formData.get("motherName"),
        dateOfBirth: formData.get("dateOfBirth"),
        gender: formData.get("gender"),
        nationality: formData.get("nationality"),
        prAddress: formData.get("prAddress"),
        phoneNumber: formData.get("phoneNumber"),
        tel: formData.get("tel"),
        pAddress: formData.get("pAddress"),
        email: formData.get("email"),
        occupation: formData.get("occupation"),
        eTin: formData.get("eTin"),
        bankName: formData.get("bankName"),
        branchName: formData.get("branchName"),
        accountNo: formData.get("baccountnumber"),
        routingNo: formData.get("routeNo")
    };

    // Log the created JavaScript object
    console.log(accountDto);
    const url = "http://localhost:8080/api/accounts";
      const xhr = new XMLHttpRequest();
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-Type", "application/json");
      xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
          alert("Form data saved successfully!");
        }
      };
      xhr.send(JSON.stringify(accountDto));
});



        // // Send the data via Ajax
        // fetch("http://localhost:8080/api/accounts", {
        //     method: "POST",
        //     body: newFormData
        // })
        // .then(response => response.json())
        // .then(data => {
        //     console.log("Account created with image:", data);
        // })
        // .catch(error => {
        //     console.error("Error creating account with image:", error);
        // });