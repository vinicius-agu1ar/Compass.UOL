Questão 1- 

Antes da execução do programa o usuario deverá se atentar, se necessario, ao login, senha e url do H2 e que existe um banco de dados base 'data.sql' para povoar, durante a execução o usuario poderá utilizar os metodos:

POST - /api/states

GET - /api/states

GET - /api/states/{id}

PUT - /api/states/{id}

DELETE - /api/states/{id}

O campo região aceita apenas os valores 'Norte', 'Nordeste' 'Centro-Oeste', 'Sudeste' e 'Sul'. 

Para filtrar os resultados por região deve-se utilizar o metodo - /api/states?nomeRegiao= e o nome da região indicada acima.

Para ordenar os estados por maior população /api/states?sort=populacao,desc

Para ordenar os estador por maior area /api/states?sort=area,desc
