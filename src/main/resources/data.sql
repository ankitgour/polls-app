insert into poll values(102, sysdate(),'Favourite programming language?');
insert into choice values(2048, 'Swift',102);
insert into vote values(101, 2048);
insert into choice values(1024, 'Python',102);
insert into vote values(102, 1024);
insert into choice values(512, 'Objective-C',102);
insert into vote values(103, 512);
insert into choice values(256, 'Ruby',102);
insert into vote values(104, 256);