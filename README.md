# Desafio Concrete Solutions


exemplo de cadastro:


PUT

http://georgedesafioconcre-env.us-west-2.elasticbeanstalk.com/desafio/concrete/cadastroUsuario

{
        "name": "João da Silva",
        "email": "joao@silva.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "987654321",
                "ddd": "21"
            }
        ]
    }


exemplo de login:

POST

http://georgedesafioconcre-env.us-west-2.elasticbeanstalk.com/desafio/concrete/login/usuario

  {
        "name": "joao@silva.org",
        "password": "hunter2"
        
    }
