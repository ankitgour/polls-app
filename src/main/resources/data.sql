insert into poll values(102, sysdate(),'Favourite programming language?');
insert into choice values(2048, 'Swift',102);
insert into vote values(101, 2048);
insert into choice values(1024, 'Python',102);
insert into vote values(102, 1024);
insert into choice values(512, 'Objective-C',102);
insert into vote values(103, 512);
insert into choice values(256, 'Ruby',102);
insert into vote values(104, 256);

insert into poll values(103, sysdate(),'Favourite sport playing?');
insert into choice values(2049, 'Cricket',103);
insert into vote values(105, 2049);
insert into choice values(1025, 'Football',103);
insert into vote values(106, 1025);
insert into choice values(513, 'Badminton',103);
insert into vote values(107, 513);
insert into choice values(257, 'Basketball',103);
insert into vote values(108, 257);