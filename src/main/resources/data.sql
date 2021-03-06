
insert into editora (id,nome,email) values (1,'Bookman','Bookman@email.com');
insert into editora (id,nome,email) values (2,'Alta Books','altabooks@email.com');

insert into autor (id,nome,data_nascimento,cidade,estado) values (1,'Fulano de Tal','1981-06-27 12:00:00','Recife',26);
insert into autor (id,nome,data_nascimento,cidade,estado) values (2,'Cicrano da Silva','2013-06-05 11:00:00','Recife',26);

insert into categoria (id,nome,descricao) values (1,'Tecnologia da Informação','Livros da área de tecnologia da informação');
insert into categoria (id,nome,descricao) values (2,'Romance','Romances nacionais e internacionais');

insert into livro (id, titulo, descricao, quantidade_paginas, editora_id,autor_id, categoria_id) values (1,'Arquitetura Limpa: O guia do artesão para estrutura e design de software', 'A "Arquitetura Limpa" de Martin não é só mais um catálogo de opções. Com base em meio século de experiência nos mais variados ambientes de software, Martin indica as escolhas que você deve fazer e explica por que elas são cruciais para o seu sucesso. ',432,2,1,1);
insert into livro (id, titulo, descricao, quantidade_paginas, editora_id,autor_id, categoria_id) values (2,'Código Limpo: Habilidades Práticas do Agile Software', 'Que tipo de trabalho você fará? Você lerá códigos aqui, muitos códigos. E você deverá descobrir o que está correto e errado nos códigos. E, o mais importante, você terá de reavaliar seus valores profissionais e seu comprometimento com o seu ofício.',456,2,2,1);
insert into livro (id, titulo, descricao, quantidade_paginas, editora_id,autor_id, categoria_id) values (3,'Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos', 'Catálogo de soluções simples e sucintas para os problemas mais freqüentes na área de projeto, assinado por quatro profissionais com grande experiência em software orientado a objetos. Um best-seller mundial.',368,1,2,1);

insert into usuario (nome, email, senha) values ('Usuario', 'usuario@email.com', '$2a$10$oYO5sGXlX53caHw3RYFX9uaPFj8Dcj6BRC8m3Lhq.wCx1jj1CzFyy');