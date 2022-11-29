Questão 1-

***QUESTÃO INCOMPLETA***

***IMPLEMENTADOS***

Ao executar o programa o usuario poderá para os associados:

POST - /associados

GET - /associados (Com opção de filtrar associados de acordo com
seu cargo político e outra de ordenar por nome)

GET - /associados/{id}

PUT - /associados/{id}

DELETE - /associados/{id}

***AINDA NÃO IMPLEMENTADO***

POST - /associados/partidos (Vincula um associado a um partido, com o
body: {“idAssociado”: 10, “idPartido”: 10})

DELETE - /associados/{id}/partidos/{id} (Remove determinado
associado daquele partido) 

***IMPLEMENTADOS***

E para os partidos:

POST - /partidos

GET - /partidos (Com a opção de filtrar partidos de acordo com sua
ideologia)

GET - /partidos/{id}

PUT - /partidos/{id}

DELETE - /partidos/{id}

***AINDA NÃO IMPLEMENTADO***

GET - /partidos/{id}/associados (Listar todos os associados daquele
partido)

o JSON de exemplo para criar um associado é:

{

    "nome": "nomeAssociado",
    
    "cargoPolitico": "VEREADOR",
    
    "dataNascimento": "dd-MM-yyyy",
    
    "sexo": "FEMININO"
}

e o exemplo para criar um partido é:

{

    "nome": "nomePartido",
    
    "sigla": "sigla",
    
    "ideologia": "CENTRO",
    
    "dataFundacao": "dd-MM-yyyy HH:mm"
}
