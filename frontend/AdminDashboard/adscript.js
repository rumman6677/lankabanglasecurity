fetch('http://localhost:8080/api/dashboard/countByGender')
    .then(response => response.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);

        const ctx = document.getElementById('pie-chart').getContext('2d');
        new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    data: values,
                    backgroundColor: ['blue', 'pink'],
                }],
            },
        });
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });

fetch('http://localhost:8080/api/dashboard/division-city-counts')
    .then(response => response.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);

        const ctx = document.getElementById('division-chart').getContext('2d');
        new Chart(ctx, {
            type: 'pie',
            data: {
                labels: labels,
                datasets: [{
                    data: values,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.7)',
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(75, 192, 192, 0.7)',
                        'rgba(153, 102, 255, 0.7)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                legend: {
                    position: 'right'
                }
            }
        });
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });

    fetch('http://localhost:8080/api/dashboard/userstatus')
    .then(response => response.json())
    .then(data => {
        const labels = Object.keys(data);
        const values = Object.values(data);

        const ctx = document.getElementById('userStatusChart').getContext('2d');
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    data: values,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.7)',
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(75, 192, 192, 0.7)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                legend: {
                    position: 'right'
                }
            }
        });
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });




    // script.js
fetch('http://localhost:8080/api/dashboard/userperbranch')
.then(response => response.json())
.then(data => {
    const labels = Object.keys(data);
    const values = Object.values(data);

    const ctx = document.getElementById('branch').getContext('2d');
    new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: values,
                backgroundColor: [
                    '#ff9999', '#66b3ff', '#99ff99', '#ffcc99', '#c2c2f0',
                    '#ffb366', '#c2f0c2', '#ffb3e6', '#d9b3ff', '#ffdb4d'
                ],
            }],
        },
    });
})
.catch(error => {
    console.error('Error fetching data:', error);
});


const burger = document.querySelector('.burger');
const navLinks = document.querySelector('.nav-links');

burger.addEventListener('click', () => {
    navLinks.classList.toggle('active');
});


// script.js
fetch('http://localhost:8080/api/dashboard/male/female/perbranch')
    .then(response => response.json())
    .then(data => {
        const branchNames = Object.keys(data);
        const maleCounts = branchNames.map(branch => data[branch]["Male"]);
        const femaleCounts = branchNames.map(branch => data[branch]["Female"]);

        const ctx = document.getElementById('branchGenderChart').getContext('2d');
        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: branchNames,
                datasets: [
                    {
                        label: 'Male',
                        data: maleCounts,
                        backgroundColor: 'blue'
                    },
                    {
                        label: 'Female',
                        data: femaleCounts,
                        backgroundColor: 'pink'
                    }
                ]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                },
                plugins: {
                    legend: {
                        display: true
                    }
                }
            }
        });
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });




    // script.js
fetch('http://localhost:8080/api/dashboard/account/peryear')
.then(response => response.json())
.then(data => {
    const years = Object.keys(data);
    const counts = Object.values(data);

    const ctx = document.getElementById('lineChart').getContext('2d');
    new Chart(ctx, {
        type: 'line',
        data: {
            labels: years,
            datasets: [{
                label: 'Account Counts',
                data: counts,
                borderColor: 'blue',
                backgroundColor: 'rgba(0, 0, 255, 0.1)',
                pointRadius: 5,
                pointBackgroundColor: 'blue',
                pointHoverRadius: 7,
                pointHoverBackgroundColor: 'blue',
            }],
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            },
            plugins: {
                legend: {
                    display: true
                }
            }
        }
    });
})
.catch(error => {
    console.error('Error fetching data:', error);
});
