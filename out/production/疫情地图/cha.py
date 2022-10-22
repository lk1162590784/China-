import pandas as pd
import requests
import json
url = 'https://api.inews.qq.com/newsqa/v1/query/inner/publish/modules/list?modules=statisGradeCityDetail,diseaseh5Shelf'
area = requests.get(url).json()
all_list = []
data = area['data']
# update_time = data['lastUpdateTime']
# print(update_time)
one=data['diseaseh5Shelf']
all_counties = one['areaTree']
# print(all_counties)
# for country_data in all_counties:
#     print(country_data['name'])
for country_data in all_counties:
    if country_data['name'] != '中国':
        continue
    else:
        all_provinces = country_data['children']
        for province_data in all_provinces:
            province_name = province_data['name']
            province_total = province_data['total']
            total_data = province_total['nowConfirm']
            time=province_total['mtime']
            total_result={'province': province_name, 'total': total_data,'time':time}
            all_list.append(total_result)
print(all_list)

# for lk in province_total:
# print(lk)
# for total_data in province_data['total']:
#     print(total_data)
#     total = total_data[0]
# total_result={'province': province_name, 'total': total}
# print(total_result)
# all_cities = province_data['total']
# for city_data in all_cities:
#     print(city_data)
#     city_name = city_data['name']
#     city_total = city_data['total']
#     province_result = {'province': province_name, 'city': city_name,'update_time': update_time}
#     province_result.update(city_total)
#     all_list.append(province_result)

# df = pd.DataFrame(all_list)
# df.to_csv('data.csv', index=False,encoding="utf_8_sig")