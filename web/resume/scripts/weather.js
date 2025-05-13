
/*     adcode citycode
池州市	341700	0566
贵池区	341702	0566
东至县	341721	0566
石台县	341722	0566
青阳县	341723	0566
*/
const cdcode = "341723";

//申请的高德地图API Key
const apiKey = "ff4b21a03d2bb3c6427c947764fc5961";

const address_api = `https://restapi.amap.com/v3/weather/weatherInfo?key=${apiKey}&city=${cdcode}&extensions=base`;
// 调用高德天气API获取天气信息
function getHomeWeather() {
    fetch(address_api)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong');
        })
        .then(data => {
            var province_city = document.getElementsByClassName("weather-head")[0];
            var humidity = document.getElementById('humidity');
            var temperature = document.getElementById('temperature');
            var weather = document.getElementById('weather1');
            var winddirection = document.getElementById('wind');
            var windpower = document.getElementById('windpower');
            var weather_iocn_str = 'icon';
            console.log(data);
            console.log(province_city);
            console.log(humidity);
            console.log(temperature);
            console.log(weather);
            console.log(winddirection);
            console.log(windpower);
            province_city.innerText = `天气情况---${data.lives[0].province}${data.lives[0].city}---`;
            humidity.innerText = `湿度:${data.lives[0].humidity}`;
            temperature.innerText = `温度:${data.lives[0].temperature}`;
            winddirection.innerText = `风向:${data.lives[0].winddirection}`;
            windpower.innerText = `风力:${data.lives[0].windpower}`;
            weather.innerText = `${data.lives[0].weather}`;
        
            var weather_iocn = document.getElementById('weather-icon');
            console.log(weather_iocn);
            var wea = data.lives[0].weather;
            if(wea == '晴'){
                weather_iocn_str = '#icon-qing';
            }else if(wea == '雾' || wea == '霾'){
                weather_iocn_str = '#icon-wu';
            }else if(wea == '多云'){
                weather_iocn_str = '#icon-duoyun';
            }else if(wea == '阴'){
                weather_iocn_str = '#icon-yin';
            }else if(wea == '风'){
                weather_iocn_str = '#icon-feng';
            }else if(wea == '雨' || wea == '小雨'|| wea == '中雨'|| wea == '大雨'){
                weather_iocn_str = '#icon-dayu';
            }else if(wea == '阵雨'){
                weather_iocn_str = '#icon-zhenyu';
            }else if(wea == '雷阵雨'){
                weather_iocn_str = '#icon-leizhenyu';
            }else if(wea == '雪'){
                weather_iocn_str = '#icon-xue';
            }else{
                weather_iocn_str = '#icon-qing';
            }
            
            
            weather_iocn.setAttribute('xlink:href',weather_iocn_str);

        })
        .catch(error => console.error("网络错误",error));
}

// 页面加载完成后调用函数获取天气信息
window.onload = getHomeWeather;
