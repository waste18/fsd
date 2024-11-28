document.addEventListener('DOMContentLoaded', () => { 
    const apiKey = 'b10c232939837495b48f22184fe46ad0'; //your api key
    const city = 'hyderabad'; 
    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

    const fetchData = async () => { 
        try { 
            const response = await axios.get(apiUrl); 
            const weatherData = response.data;
            updateGraph(weatherData.main.temp); 
        } catch (error) { 
            console.error('Error fetching weather data:', error.message); 
        } 
    };

    const updateGraph = (temperature) => { 
        const ctx = document.getElementById('weatherGraph').getContext('2d');
        new Chart(ctx, { 
            type: 'bar', 
            data: { 
                labels: ['Temperature'], 
                datasets: [{ 
                    label: 'Temperature (°C)', 
                    data: [temperature], 
                    backgroundColor: ['#36A2EB'], 
                }], 
            }, 
            options: { 
                scales: { 
                    y: { 
                        beginAtZero: true, 
                    }, 
                }, 
            }, 
        }); 
    };

    fetchData();
});