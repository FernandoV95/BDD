use covidHistorico

execute sp_helpindex 'dbo.datoscovid'
--Indice Agrupado
create clustered index IDEX_EntidadResidencia ON dbo.datoscovid(ENTIDAD_RES)

create nonclustered index IDEX_Municipio_NA ON dbo.datoscovid(MUNICIPIO_RES)


/*1. Listar los casos positivos por entidad de residencia*/

select  * from dbo.datoscovid where 
CLASIFICACION_FINAL between 1 and 3 order by ENTIDAD_RES;

--Alternativa
select ENTIDAD_RES, count(*) Confirmados
from dbo.datoscovid where 
CLASIFICACION_FINAL between 1 and 3
group by ENTIDAD_RES order by ENTIDAD_RES;



--2 Listar los casos sospechosos por entidad



select ENTIDAD_RES, count(*) No_Total_Confirmados
from dbo.datoscovid where 
CLASIFICACION_FINAL between 1 and 3
group by ENTIDAD_RES
order by ENTIDAD_RES;


--Solucion 3
select top 5 cc.ENTIDAD_RES, cc.MUNICIPIO_RES, cc.confirmado, cs.sospechoso
from (select ENTIDAD_RES, MUNICIPIO_RES, count(*) as sospechoso
      from dbo.datoscovid where CLASIFICACION_FINAL = 6
      group by ENTIDAD_RES, MUNICIPIO_RES
      ) cs
inner join
(select ENTIDAD_RES, MUNICIPIO_RES, count (*) as confirmado
 from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3
 group by ENTIDAD_RES, MUNICIPIO_RES) cc
on cc.ENTIDAD_RES =  cs.ENTIDAD_RES and cs.MUNICIPIO_RES = cc.MUNICIPIO_RES
order by cc.ENTIDAD_RES

--Alternativa
select cc.Entidad_Res, cc.Municipio_Res, cc.Confirmado, cs.Sospechosos
from (select ENTIDAD_RES, MUNICIPIO_RES, count(*) as Sospechosos 
from dbo.datoscovid where CLASIFICACION_FINAL=6 
group by ENTIDAD_RES, MUNICIPIO_RES) cs INNER JOIN
(select Entidad_RES, MUNICIPIO_RES, count(*) as Confirmado 
from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3
group by ENTIDAD_RES, MUNICIPIO_RES) cc ON
cc.Entidad_RES = cs.Entidad_RES and cs.MUNICIPIO_RES = cc.MUNICIPIO_RES
order by cc.Entidad_RES, cc.MUNICIPIO_RES


--Solucion 4

select top 1 MUNICIPIO_RES,count(MUNICIPIO_RES) as Muertes_Confirmadas from dbo.datoscovid where FECHA_DEF!='9999-99-99' group by MUNICIPIO_RES

--Solucion 5
select ENTIDAD_NAC, count(ENTIDAD_RES) as Defunciones  from dbo.datoscovid where FECHA_DEF!='9999-99-99' and CLASIFICACION_FINAL=6 and  NEUMONIA=1 group by ENTIDAD_NAC order by Defunciones

--Solucion 6
--Listar por entidad el total de casos sospechosos, casos confirmados, 
--total de defunciones en los meses de marzo a agosto 2020 y de diciembre 2020 a mayo 2021.

select a.ENTIDAD_RES, a.Sospechosos_MarzoAgosto_2020, b.Sospechosos_Diciembre2020_Marzo_2021, c.Confirmados_MarzoAgosto_2020, d.Confirmados_Diciembre2020_Marzo_2021,
e.Defunciones_MarzoAgosto_2020, f.Defunciones_Diciembre2020_Marzo_2021 

from (
select ENTIDAD_RES, count (CLASIFICACION_FINAL) as Sospechosos_MarzoAgosto_2020 from dbo.datoscovid
where CLASIFICACION_FINAL=6 and FECHA_DEF between '2020-03-01' and '2020-08-01'
group by ENTIDAD_RES) a JOIN

(select ENTIDAD_RES, count (CLASIFICACION_FINAL) as Sospechosos_Diciembre2020_Marzo_2021 from dbo.datoscovid
where CLASIFICACION_FINAL=6 and FECHA_DEF between '2020-12-01' and '2021-03-01'
group by ENTIDAD_RES) b ON

a.ENTIDAD_RES = b.ENTIDAD_RES JOIN

(select ENTIDAD_RES, count (CLASIFICACION_FINAL) as Confirmados_MarzoAgosto_2020 from dbo.datoscovid
where CLASIFICACION_FINAL between 1 and 3 and FECHA_DEF between '2020-03-01' and '2020-08-01'
group by ENTIDAD_RES) c  ON

b.ENTIDAD_RES=c.ENTIDAD_RES JOIN

(select ENTIDAD_RES, count (CLASIFICACION_FINAL) as Confirmados_Diciembre2020_Marzo_2021 from dbo.datoscovid
where CLASIFICACION_FINAL between 1 and 3 and FECHA_DEF between '2020-12-01' and '2021-03-01'
group by ENTIDAD_RES) d ON

c.ENTIDAD_RES=d.ENTIDAD_RES JOIN

(select ENTIDAD_RES, count (FECHA_DEF) as Defunciones_MarzoAgosto_2020 from dbo.datoscovid 
where FECHA_DEF between '2020-03-01' and '2020-08-01' and FECHA_DEF!='9999-99-99'  group by ENTIDAD_RES) e ON

d.ENTIDAD_RES=e.ENTIDAD_RES JOIN

(select ENTIDAD_RES, count (FECHA_DEF) as Defunciones_Diciembre2020_Marzo_2021 from dbo.datoscovid 
where FECHA_DEF between '2020-12-01' and '2021-03-01' and FECHA_DEF!='9999-99-99'  group by ENTIDAD_RES ) f ON

e.ENTIDAD_RES = f.ENTIDAD_RES Order by a.ENTIDAD_RES;



--Solucion 7
--Listar los 5 municipios con el mayor número de casos confirmados 
--en niños menos de 13 años con alguna comorbilidad reportada y 
--cuantos de esos casos fallecieron.

select  MUNICIPIO_RES, count(EDAD) as Defunciones from dbo.datoscovid 
where edad<13 and FECHA_DEF!='9999-99-99' and ASMA=1 and NEUMONIA=1 group by MUNICIPIO_RES order by Defunciones desc


--8. Determinar si en el año 2020 hay una mayor cantidad de defunciones menores de edad que en el año 2021 y 2022.

DECLARE @D2020 int
DECLARE @D2021 int
DECLARE @D2022 int

select @D2020 = SUM(Defunciones20) from (select count(*) as Defunciones20, EDAD from dbo.datoscovid where FECHA_DEF like '2020%' and  FECHA_DEF!='9999-99-99' and EDAD<18 group by EDAD) AS a;

select @D2021 = SUM(Defunciones21) from (select count(*) as Defunciones21,EDAD from dbo.datoscovid where FECHA_DEF like '2021%' and  FECHA_DEF!='9999-99-99' and EDAD<18 group by EDAD) as b;

select @D2022 = SUM(Defunciones22) from (select count(*) as Defunciones22,EDAD from dbo.datoscovid where FECHA_DEF like '2022%' and  FECHA_DEF!='9999-99-99' and EDAD<18 group by EDAD) as c;

if @D2020 > @D2021  and @D2020 > @D2022 
begin 
print 'Año 2020 .... Mayor cantidad de muertes en menores de edad '
end 

else if @D2021 > @D2020  and @D2021 > @D2022 
begin 
print 'Año 2021 .... Mayor cantidad de muertes en menores de edad '
end 

else
begin 
print 'Año 2022 .... Mayor cantidad de muertes en menores de edad '
end 





--9. Determinar si en el año 2021 hay un pocentaje mayor al 60 de casos reportados que son confirmados 
--por estudios de laboratorio en comparación al año 2020.


Declare @A2020 int;
Declare @A2021 int;
Declare @x real;
Declare @Porc1 real;
Declare @Porc2 real;



SET @A2020 = (select SUM(Resultado_lab) from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3 and FECHA_INGRESO like '2020%')
SET @A2021 = (select SUM(Resultado_lab) from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3 and FECHA_INGRESO like '2021%')
SET @x = @A2020
SET @Porc1= @A2021/@x
SET @Porc2= (@A2020/100)*60
IF @Porc1 <= @Porc2
BEGIN
PRINT 'El porcentaje es menor al 60% del año 2020'
END
ELSE
BEGIN
PRINT 'El porcentaje es Mayor al 60% del año 2020'
END



--10. Determinar en que rango de edad: menor de edad, 19 a 40, 40 a 60 o mayor de 60 hay mas 
--casos reportados que se hayan recuperado. 


DECLARE @Men int
DECLARE @JA int
DECLARE @Adu int
DECLARE @May int

SELECT @Men= SUM(Edades1) FROM(select COUNT(*) AS Edades1 , EDAD FROM dbo.datoscovid WHERE EDAD < 18 and FECHA_DEF='9999-99-99' group by EDAD) AS w ;
SELECT @JA = SUM(Edades2)FROM(SELECT COUNT(*) AS Edades2, Edad FROM dbo.datoscovid WHERE EDAD between 19 and 40 and FECHA_DEF='9999-99-99' group by EDAD) AS x;
SELECT @Adu = SUM(Edades3) FROM(SELECT COUNT(*) AS Edades3, Edad FROM dbo.datoscovid WHERE EDAD between 40 and 60 and FECHA_DEF='9999-99-99' group by EDAD) AS y;
SELECT @May = SUM(Edades) FROM( SELECT COUNT(*) as Edades, Edad FROM dbo.datoscovid WHERE EDAD > 60 and FECHA_DEF='9999-99-99' group by EDAD) AS z;

if @Men > @JA and @Men > @Adu and @Men > @May  
begin
print 'Los menores de edad tienen mayor numero de recuperados'
end

else if  @JA> @Men and  @JA > @Adu and  @JA > @May  
begin
print 'Los menores jovenes adultos tienen mayor numero de recuperados'
end

else if  @Adu>@Men and  @Adu> @JA and  @JA > @May  
begin
print 'Los adultos tienen mayor numero de recuperados'
end

else
begin
print 'Los mayores de edad tienen mayor numero de recuperados'
end

