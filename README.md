# SFM-project
[GIthub](https://github.com/attila1020/SFM-project.git)
[Trello](https://trello.com/b/gmqoL5Zn/project)
## Technológiák
**Név:** GasStation Dashboard

**Frontend:** HTML, CSS, Js NGINX-ben

**Backend:** SpringBoot

**Database:** MySQL

**Java Version:** 17

**Maven version:** 4.0.0

**Deploy:** Docker, docker-compose

## Leírás
Egy olyan webalkalmazás, amely egy benzinkúton található termékeket tartja nyílván, ár és készlet szerint. Kezelőfelületet nyújt ezzel a dolgozók részére a nyílvántartás kezelésére és az ügyefelek számára a tájékozódásra, különböző terméktörténetekkel és egy hűségprogrammal.


## API Endpointok:
 ### **Not implemented yet!**


## Alkalmazás futtatása:
```bash
docker-compose up
```
Elíndít 3 docker containert (frontend, backend, mysql-db) ezekbe másolva az applikácót és összekötve őket egy hálózaton keresztül.

### Portok:
|   Container   |   Port    |
| ------------- | --------- |
|   frontend    |   3000    |
|   backend     |   8080    |
|   mysql-db    |   3060    |

## Adatbázis struktúra:
![image](frontend/rsc/datab.png)

## Jövőbeli fejlesztési lehetőségek
- Több benzinkút weboldalának együttes támogatása
- Országos szinten való nyilvántartás
- Több termék hozzáadása
