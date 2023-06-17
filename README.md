
# MVC-Oficina-II

Projeto desenvolvido para a disciplina de Oficina de desenvolvimento de Software II, do curso de Sistemas para Internet - IFMT.

## Tecnologias utilizadas

Java Spring Boot JPA \
Hibernate ORM \
Thymeleaf \
Bootstrap \
PostgreSQL 

## Setup

Necessário criar SEQUENCES no banco. 

```bash
CREATE SEQUENCE IF NOT EXISTS aluno_sequence AS integer INCREMENT BY 1 MINVALUE 1 START WITH 1;

CREATE SEQUENCE IF NOT EXISTS tipo_atividade_sequence AS integer INCREMENT BY 1 MINVALUE 1 START WITH 1;

CREATE SEQUENCE IF NOT EXISTS atividade_sequence AS integer INCREMENT BY 1 MINVALUE 1 START WITH 1;

CREATE SEQUENCE IF NOT EXISTS avaliador_sequence AS integer INCREMENT BY 1 MINVALUE 1 START WITH 1;

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence AS integer INCREMENT BY 1 MINVALUE 1 START WITH 1;
```


    
## Endpoints disponíveis

#### Create Aluno

```http
  POST /aluno
  Body:
{
    "cpf":"999.999.999-99",
    "nome":"Admin",
    "matricula":"73420001",
    "email":"admin@admin.com.br",
    "senha":"123456",
    "telefone":"65999852441"
}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Nome do aluno |
| `matricula` | `string` |Matricula |
| `email` | `string` | E-mail. Será utilizado para login |
| `senha` | `string` | Senha. A senha é encriptada para ser salva no banco. |
| `telefone` | `string` | Telefone |
| `cpf` | `string` | CPF |


#### Mudar Status da Atividade

Atividade possui quatro status (representados pelo Enum StatusAtividade):
"PENDENTE", "DEFERIDO", "INDEFERIDO", "DELETADO".
O sistema não permite edição nas Atividades que não tiverem status PENDENTE

```http
  PUT /atividade/${id}/${status}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | O ID da atividade |
| `status`      | `string` | String referente ao valor do Enum StatusAtividade (ex.: DEFERIDO) |
