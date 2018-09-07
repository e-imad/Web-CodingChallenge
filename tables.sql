CREATE TABLE `user` (
  `Email` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `user`
  ADD PRIMARY KEY (`Email`);
  
  CREATE TABLE `liked` (
  `user` varchar(40) NOT NULL,
  `LocationId` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `liked`
  ADD PRIMARY KEY (`LocationId`,`user`),
  ADD KEY `Fk` (`user`);

ALTER TABLE `liked`
  ADD CONSTRAINT `Fk` FOREIGN KEY (`user`) REFERENCES `user` (`Email`) ON DELETE CASCADE ON UPDATE CASCADE;
  
CREATE TABLE `disliked` (
  `user` varchar(40) NOT NULL,
  `LocationId` varchar(40) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `disliked`
  ADD PRIMARY KEY (`user`,`LocationId`,`time`);
