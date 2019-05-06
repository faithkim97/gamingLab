;              
-- CREATE USER IF NOT EXISTS GAMINGLAB SALT '5c0801e39302a6db' HASH '492d1771ecbc38423e2a195111d6764c78160fed9371e5a3e9de17e59a0e92c4' ADMIN;
-- CREATE SEQUENCE PUBLIC.HIBERNATE_SEQUENCE START WITH 692;
-- CREATE CACHED TABLE PUBLIC.CONSOLE(
--     ID INTEGER NOT NULL,
--     CONSOLE VARCHAR(255)
-- );
ALTER TABLE PUBLIC.CONSOLE ADD CONSTRAINT PUBLIC.CONSTRAINT_9 PRIMARY KEY(ID);
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.CONSOLE;  
INSERT INTO PUBLIC.CONSOLE(ID, CONSOLE) VALUES
(6, 'ps4vr'),
(15, 'ps4'),
(183, 'nintendoswitch'),
(197, 'ps3'),
(264, 'pc'),
(280, 'htc_vive'),
(396, 'xbox360'),
(486, 'xbox1');             
-- CREATE CACHED TABLE PUBLIC.GAME(
--     ID INTEGER NOT NULL,
--     DESCRIPTION CLOB,
--     IS_CHECKED_OUT BOOLEAN,
--     IS_DIGITAL BOOLEAN,
--     QUANTITY INTEGER NOT NULL,
--     RATING INTEGER,
--     TITLE VARCHAR(255)
-- );
-- ALTER TABLE PUBLIC.GAME ADD CONSTRAINT PUBLIC.CONSTRAINT_2 PRIMARY KEY(ID);
-- 101 +/- SELECT COUNT(*) FROM PUBLIC.GAME;   
INSERT INTO PUBLIC.GAME(ID, DESCRIPTION, IS_CHECKED_OUT, IS_DIGITAL, QUANTITY, RATING, TITLE) VALUES
(32, 'live the life of  jodie holmes, a young woman who possesses supernatural powers through her psychic link to a mysterious invisible entity. as a small child, jodie holmes became a government lab rat due to her strange psychic powers caused by her link to an incorporeal psychic entity known as aiden.', FALSE, FALSE, 1, 3, 'beyond: two souls'),
(42, 'what happens when we have human-like ai robots as caretakers, police, a family member?', FALSE, FALSE, 1, 3, 'detroit become human'),
(49, 'you get to become an eagle and feel the simulation of flying!', FALSE, FALSE, 1, 1, 'eagle flight'),
(59, 'set in post-apocalyptic world after a nuclear explosion; the player explores this dystopian world through quests and building towns', FALSE, FALSE, 1, 3, 'fallout 4'),
(68, 'a virtual reality space adventure set on a hostile alien planet.', FALSE, FALSE, 1, 3, 'farpoint'),
(75, 'gary the gull is an vr animated interactive short film where you are part of the story! respond to gary''s questions -- nodding, shaking your head, talking -- and see how your decisions affect how the story plays out.', FALSE, FALSE, 1, 1, 'gary the gull'),
(80, 'running out of options, the crew risks everything in a series of daring and dangerous heists that could set them up for life. ', FALSE, TRUE, 1, 3, 'grand theft auto 5'),
(90, 'game revolves around a plot and narrative threads that explore a moral proposition. you assume the role of multiple characters with very different backgrounds, motivations, and skills in a world where each player decision affects what will follow.', FALSE, FALSE, 1, 3, 'heavy rain'),
(97, 'the story is set in the 31st century, in a world where humans have regressed to primitive tribal societies as a result of some unspecified calamity. their technologically advanced predecessors are vaguely remembered as the "old ones". large robotic creatures known merely as "machines" now dominate the earth.', FALSE, FALSE, 1, 2, 'horizon zero dawn'),
(102, 'journey''s story is told wordlessly through gameplay and using cutscenes. the player''s character begins on a sand dune in a seemingly endless desert.', FALSE, TRUE, 1, 1, 'journey'),
(109, 'life is strange follows the exploits of 18-year old max caulfield, a high school senior who learns she has the power to rewind time when she saves her childhood friend, chloe price, from being killed.', FALSE, FALSE, 3, 3, 'life is strange'),
(116, 'after the murder of his surrogate family at the hands of the italian mafia, vietnam war veteran lincoln clay seeks vengeance on those who took away the only thing that mattered to him.', FALSE, FALSE, 1, 3, 'mafia 3'),
(124, STRINGDECODE('in the aftermath of the events of ground zeroes and the destruction of militaires sans fronti\u00e8res falls into a coma. nine years later, he awakens and helps lead a new mercenary group, diamond dogs.'), FALSE, FALSE, 2, 3, 'metal gear solid: the phantom pain'),
(131, 'you play as an octopus that conceals his identity to be a human dad', FALSE, TRUE, 2, 1, 'octodad: the dadliest catch'),
(138, 'visit different worlds in vr', FALSE, FALSE, 1, 3, 'playstation vr worlds'),
(143, 'protagonist wander''s goal is to resurrect the maiden mono by destroying the giant colossi', FALSE, FALSE, 1, 2, 'shadow of the colossus'),
(148, 'superhot sets the player in a minimalistic environment, taking out hostile attackers that are trying to kill them', FALSE, FALSE, 1, 2, 'superhot'),
(153, 'lee is on his way to prison, until he realizes that there is a zombie apocalypse. will he and the little girl clementine survive this ordeal?', FALSE, FALSE, 1, 3, 'the walking dead: the telltale series (collection)'),
(160, 'lee is on his way to prison, until he realizes that there is a zombie apocalypse. will he and the little girl clementine survive this ordeal?', FALSE, FALSE, 2, 3, 'the walking dead: the telltale series '),
(167, 'lara set out on her first expedition aboard the ship endurance, with the intention of finding the lost kingdom of yamatai. by her suggestion and against whitman''s advice, the expedition ventures into the dragon''s triangle. ', FALSE, FALSE, 2, 3, 'tomb raider: definitive edition');    
INSERT INTO PUBLIC.GAME(ID, DESCRIPTION, IS_CHECKED_OUT, IS_DIGITAL, QUANTITY, RATING, TITLE) VALUES
(174, 'in india, treasure hunter chloe frazer searches for the legendary tusk of ganesh, the son of hindu god shiva, who lost the tusk while defending his father''s temple. chloe''s own father was killed by bandits while searching for the tusk. chloe slips past insurgents and meets up with mercenary nadine ross. they sneak into the office of the insurgents'' leader, asav, who wants to use the tusk to rally india into a civil war. chloe and nadine steal a map pointing toward the tusk within the ancient hoysala empire and a disc that acts as a key.', FALSE, FALSE, 1, 3, 'uncharted: the lost legacy'),
(181, 'link needs to save the hyrule kingdom and princess zelda from destruction', FALSE, FALSE, 1, 1, 'the legend of zelda: breath of the wild'),
(189, 'play as mario characters and race against your friends!', FALSE, FALSE, 1, 0, 'mario kart 8 deluxe'),
(196, 'despite the efforts of the u.s. marine corps and british special air service in the previous game, the ultranationalists seize control of the russian federation, making imran zakhaev a martyr and straining diplomatic relations with the united states. ', FALSE, FALSE, 2, 3, 'call of duty: modern warfare 2'),
(206, 'cole phelps, a war hero and rookie cop, moves up the ranks and solves dark cases in 1940s los angeles.', FALSE, FALSE, 1, 3, 'la noire'),
(211, 'you are commander shepard creating a peaceful universe for all alien species; includes mass effect 1, 2, and 3', FALSE, FALSE, 1, 3, 'mass effect trilogy'),
(217, 'chell needs to escape from the aperture science research lab by solving puzzles', FALSE, FALSE, 1, 1, 'portal 2'),
(224, 'john marstonis taken from his family by bureau of investigation agents edgar ross and his partner, archer fordham, and will only be granted amnesty when he brings the remaining members of his old gang to justice.', FALSE, FALSE, 1, 3, 'red dead redemption'),
(231, 'build your own house, family, and a community of sims characters!', FALSE, FALSE, 1, 2, 'the sims 3'),
(236, 'the player is introduced in a small basement office by two accountants  through a phone call as a candidate for a new "virtual reality accounting" experiment, which supposedly increases efficiency in accounting', FALSE, TRUE, 1, 0, 'accounting vr'),
(246, 'a story about love, sacrifice and a deep bond between a girl and her mother', FALSE, TRUE, 1, 0, 'allumette'),
(255, 'blocks lets you easily create 3d objects in virtual reality, no matter your modelling experience.', FALSE, TRUE, 1, 0, 'blocks'),
(262, 'the literature club is full of cute girls! will you write the way into their heart? this game is not suitable for children or those who are easily disturbed.', FALSE, TRUE, 1, 3, 'dokie dokie literature club'),
(270, 'found is an interactive short film experience. its story speaks to the connection and lack there of between nature, technology and fellow travelers as you make your way through a fantastical yet familiar world.', FALSE, TRUE, 1, 0, 'found'),
(279, 'pearl vr follows a girl and her dad as they crisscross the country chasing their dreams.', FALSE, TRUE, 1, 0, 'google spotlight stories: pearl'),
(285, 'in the most important match of his life, the once mighty masked luchador, son of jaguar, faces his legacy, his family, and what it means to be a part of something bigger than himself.', FALSE, TRUE, 1, 0, 'google spotlight stories: son of jaguar'),
(290, 'sonaria follows two ever-changing creatures as they flow from one life-form to another on a vivid journey of sound and light.', FALSE, TRUE, 1, 0, 'google spotlight stories: sonaria'),
(295, 'vertical shoot ''em up that features an unique polarity-switching gameplay', FALSE, TRUE, 1, 0, 'ikaruga'),
(302, 'night in the woods is an adventure game focused on exploration, story, and character, featuring dozens of characters to meet and lots to do across a lush, vibrant world.', FALSE, TRUE, 1, 2, 'night in the woods'),
(312, ' your job as immigration inspector is to control the flow of people entering the arstotzkan side of grestin from kolechia.', FALSE, TRUE, 1, 2, 'papers, please');    
INSERT INTO PUBLIC.GAME(ID, DESCRIPTION, IS_CHECKED_OUT, IS_DIGITAL, QUANTITY, RATING, TITLE) VALUES
(317, 'chell needs to escape from the aperture science research lab by solving puzzles', FALSE, TRUE, 1, 2, 'portal '),
(322, 'this classic action/adventure platformer from acclaimed developers double fine productions follows the story of a young psychic named razputin.', FALSE, TRUE, 1, 2, 'psychonauts'),
(327, 'as a soul transitioning into the afterlife, senza peso shepherds you on a spiritual journey through a beautifully dark world of lost souls and redemption.', FALSE, TRUE, 1, 0, 'senza peso'),
(336, 'a third-person modern military shooter designed to challenge players'' morality by putting them in the middle of unspeakable situations.', FALSE, FALSE, 2, 3, 'spec ops: the line'),
(343, 'an educational virtual reality experience that takes the user inside the human body.', FALSE, TRUE, 1, 1, 'the body vr: inside a cell'),
(350, 'the cubicle is a short vr experience about your regular everyday job in an office, or is it?', FALSE, TRUE, 1, 1, 'the cubicle.'),
(357, STRINGDECODE('welcome to the lab, a compilation of valve\u2019s room-scale vr experiments set in a pocket universe within aperture science. fix a robot, defend a castle, adopt a mechanical dog, and more. still not sold? it\u2019s free!'), FALSE, TRUE, 1, 1, 'the lab'),
(362, 'rec room is the best place to hang out with friends from all around the world! play multiplayer games like paintball, or just chill in the park.', FALSE, TRUE, 1, 1, 'the rec room'),
(370, 'become a secret agent in the 1950s and observe your neighbours to find the communist spy!', FALSE, TRUE, 1, 2, 'the red stare'),
(377, STRINGDECODE('\u201cthe rose and i\u201d is about loneliness, friendship, love, and loss. come meet a lonely rose living in the unlikeliest of places, and join her as she transports you to a brand new universe.'), FALSE, TRUE, 1, 1, 'the rose and i'),
(384, 'build your own house, family, and a community of sims characters!', FALSE, FALSE, 2, 2, 'the sims 4'),
(390, 'choose a side and fight for control of nexus, while uncovering the secrets of the hyper-advanced eldan, that disappeared from the planet long ago.', FALSE, TRUE, 1, 2, 'the wildstar'),
(395, 'play as ezio the assassin and explore italy', FALSE, FALSE, 1, 3, 'assassin''s creed 2'),
(401, 'the darkspawns are taking over fereldan. you as the grey warden must save your country but must also overthrow the fereldan political corruption.', FALSE, FALSE, 1, 3, 'dragon age: origins'),
(408, 'sequel to da:origins; now that the blight is over, you are now the commander of the grey wardens in amaranthine.', FALSE, FALSE, 1, 3, 'dragon age: awakening'),
(415, 'hawke is trying to escape the blight and create a name for themsef as the champion of kirkwall.', FALSE, FALSE, 1, 3, 'dragon age 2'),
(422, 'you as the inquisitor have the ability to seal rifts and protect the world from being demolished by demons.', FALSE, FALSE, 1, 3, 'dragon age inquisition'),
(429, 'the dragon had taken your heart away, and now it is your quest to take it back.', FALSE, FALSE, 1, 3, 'dragon''s dogma'),
(436, 'the game takes place in sanctuary, the dark fantasy world of the diablo series, twenty years after the events of diablo ii. ', FALSE, FALSE, 1, 3, 'diablo 3'),
(443, 'the game for the most part takes place within the dream world of chopin, with brief segments in the real world, where chopin is on his death bed. ', FALSE, FALSE, 1, 3, 'eternal sonata'),
(449, 'your world is overrun by zombies, and now you must try to survive this apocalypse by getting to the safe house.', FALSE, FALSE, 1, 3, 'left 4 dead'),
(457, 'your world is overrun by zombies, and now you must try to survive this apocalypse by getting to the safe house.', FALSE, FALSE, 1, 3, 'left 4 dead 2'),
(465, 'travel around cyrodil as you do side quests and join cool guilds; gates of oblivion are opened throughout cyrodil and it is your job to close them', FALSE, FALSE, 1, 3, 'elder scrolls: oblivion'),
(475, 'dragons were supposed to be long extinct, but now they''re coming back! you, the dragonborn, are the only one who can destroy the dragons before the dragons can destory skyrim', FALSE, FALSE, 1, 3, 'elder scrolls: skyrim');    
INSERT INTO PUBLIC.GAME(ID, DESCRIPTION, IS_CHECKED_OUT, IS_DIGITAL, QUANTITY, RATING, TITLE) VALUES
(484, 'build your own city', FALSE, FALSE, 1, 0, 'cities: skyline'),
(492, 'a deputy is sent to the town of hope county to arrest joseph seed, a corrupt evangelical religious leader who rules the town with the help of his disturbed followers.', FALSE, FALSE, 1, 3, 'farcry 5'),
(514, NULL, FALSE, FALSE, 1, NULL, 'console'),
(541, NULL, FALSE, FALSE, 1, NULL, 'fuck2'),
(543, NULL, FALSE, FALSE, 1, NULL, 'fuck2'),
(545, NULL, FALSE, FALSE, 1, NULL, 'fuck2'),
(547, NULL, FALSE, FALSE, 1, NULL, 'fuck2'),
(549, NULL, FALSE, FALSE, 1, NULL, 'fuck2'),
(571, NULL, FALSE, FALSE, 1, NULL, 'hELP'),
(577, NULL, FALSE, FALSE, 1, NULL, 'add'),
(579, NULL, FALSE, FALSE, 1, NULL, 'add'),
(581, NULL, FALSE, FALSE, 1, NULL, 'add'),
(583, NULL, FALSE, FALSE, 1, NULL, 'add'),
(585, NULL, FALSE, FALSE, 1, NULL, 'add'),
(587, NULL, FALSE, FALSE, 1, NULL, 'add'),
(589, NULL, FALSE, FALSE, 1, NULL, 'add'),
(591, NULL, FALSE, FALSE, 1, NULL, 'add'),
(593, NULL, FALSE, FALSE, 1, NULL, 'add'),
(595, NULL, FALSE, FALSE, 1, NULL, 'add'),
(597, NULL, FALSE, FALSE, 1, NULL, 'add'),
(599, NULL, FALSE, FALSE, 1, NULL, 'add'),
(601, NULL, FALSE, FALSE, 1, NULL, 'add'),
(603, NULL, FALSE, FALSE, 1, NULL, 'add'),
(605, NULL, FALSE, FALSE, 1, NULL, 'add'),
(607, NULL, FALSE, FALSE, 1, NULL, 'add'),
(609, NULL, FALSE, FALSE, 1, NULL, 'add'),
(611, NULL, FALSE, FALSE, 1, NULL, 'add'),
(613, NULL, FALSE, FALSE, 1, NULL, 'add'),
(615, NULL, FALSE, FALSE, 1, NULL, 'add'),
(617, NULL, FALSE, FALSE, 1, NULL, 'add'),
(619, NULL, FALSE, FALSE, 1, NULL, 'add'),
(621, NULL, FALSE, FALSE, 1, NULL, 'add'),
(653, NULL, FALSE, FALSE, 1, NULL, 'fwe'),
(660, NULL, FALSE, FALSE, 1, NULL, 'fff'),
(667, NULL, FALSE, FALSE, 1, NULL, 'working'),
(681, NULL, FALSE, TRUE, 1, 3, 'assassin''s creed: freedom cry'),
(690, NULL, FALSE, FALSE, 1, NULL, 'test');         
-- CREATE CACHED TABLE PUBLIC.GAME_CONSOLE(
--     ID INTEGER NOT NULL,
--     CONSOLE_ID INTEGER,
--     GAME_ID INTEGER
-- );
-- ALTER TABLE PUBLIC.GAME_CONSOLE ADD CONSTRAINT PUBLIC.CONSTRAINT_5 PRIMARY KEY(ID);
-- 56 +/- SELECT COUNT(*) FROM PUBLIC.GAME_CONSOLE;            
INSERT INTO PUBLIC.GAME_CONSOLE(ID, CONSOLE_ID, GAME_ID) VALUES
(43, 15, 42),
(51, 6, 49),
(62, 15, 59),
(69, 6, 68),
(76, 6, 75),
(83, 15, 80),
(92, 15, 90),
(98, 15, 97),
(103, 15, 102),
(111, 15, 109),
(118, 15, 116),
(125, 15, 124),
(132, 15, 131),
(139, 6, 138),
(144, 15, 143),
(149, 6, 148),
(155, 15, 153),
(162, 15, 160),
(168, 15, 167),
(175, 15, 174),
(184, 183, 181),
(190, 183, 189),
(198, 197, 196),
(207, 197, 206),
(212, 15, 211),
(218, 197, 217),
(225, 197, 224),
(232, 197, 231),
(265, 264, 262),
(281, 280, 279),
(286, 280, 285),
(291, 280, 290),
(296, 264, 295),
(305, 264, 302),
(313, 264, 312),
(318, 264, 317),
(323, 264, 322),
(337, 264, 336),
(385, 264, 384),
(391, 264, 390),
(397, 396, 395),
(403, 396, 401),
(410, 396, 408),
(417, 396, 415),
(424, 396, 422),
(431, 396, 429),
(438, 396, 436),
(444, 396, 443),
(451, 396, 449),
(459, 396, 457),
(468, 396, 465),
(478, 396, 475),
(487, 486, 484),
(494, 486, 492),
(507, 15, 32),
(685, 15, 681);     
-- CREATE CACHED TABLE PUBLIC.GAME_GENRE(
--     ID INTEGER NOT NULL,
--     GAME_ID INTEGER,
--     GENRE_ID INTEGER
-- );
-- ALTER TABLE PUBLIC.GAME_GENRE ADD CONSTRAINT PUBLIC.CONSTRAINT_8 PRIMARY KEY(ID);
-- 100 +/- SELECT COUNT(*) FROM PUBLIC.GAME_GENRE;             
INSERT INTO PUBLIC.GAME_GENRE(ID, GAME_ID, GENRE_ID) VALUES
(31, 32, 29),
(33, 32, 30),
(41, 42, 40),
(48, 49, 46),
(50, 49, 47),
(58, 59, 56),
(60, 59, 57),
(61, 59, 12),
(67, 68, 12),
(74, 75, 40),
(79, 80, 30),
(81, 80, 57),
(82, 80, 12),
(89, 90, 29),
(91, 90, 40),
(96, 97, 56),
(101, 102, 40),
(108, 109, 40),
(110, 109, 29),
(115, 116, 30),
(117, 116, 57),
(123, 124, 122),
(130, 131, 40),
(137, 138, 46),
(142, 143, 30),
(147, 148, 12),
(152, 153, 40),
(154, 153, 29),
(159, 160, 40),
(161, 160, 29),
(166, 167, 30),
(173, 174, 30),
(180, 181, 30),
(182, 181, 57),
(188, 189, 47),
(195, 196, 12),
(205, 206, 30),
(210, 211, 56),
(216, 217, 215),
(223, 224, 30),
(230, 231, 46),
(235, 236, 40),
(238, 236, 46),
(245, 246, 1),
(254, 255, 252),
(256, 255, 253),
(261, 262, 1),
(269, 270, 40),
(271, 270, 1),
(278, 279, 40),
(284, 285, 40),
(289, 290, 40),
(303, 302, 29),
(304, 302, 40),
(316, 317, 215),
(321, 322, 30),
(326, 327, 40),
(328, 327, 1),
(335, 336, 30),
(342, 343, 252),
(344, 343, 46),
(351, 350, 46),
(356, 357, 30),
(361, 362, 40),
(363, 362, 1),
(369, 370, 30),
(376, 377, 1),
(383, 384, 46),
(389, 390, 388),
(394, 395, 30),
(400, 401, 56),
(402, 401, 30),
(407, 408, 56),
(409, 408, 30),
(414, 415, 56),
(416, 415, 30),
(421, 422, 56),
(423, 422, 30),
(428, 429, 56),
(430, 429, 30),
(435, 436, 56),
(437, 436, 30),
(442, 443, 56),
(448, 449, 12),
(456, 457, 12),
(464, 465, 12),
(466, 465, 56),
(467, 465, 57),
(474, 475, 12),
(476, 475, 56),
(477, 475, 57),
(483, 484, 252),
(485, 484, 46),
(491, 492, 30),
(493, 492, 12),
(654, 653, 122),
(655, 653, 215),
(656, 653, 252),
(682, 681, 30),
(683, 681, 40);               
-- CREATE CACHED TABLE PUBLIC.GAME_MODE(
--     ID INTEGER NOT NULL,
--     GAME_ID INTEGER,
--     MODE_ID INTEGER
-- );
-- ALTER TABLE PUBLIC.GAME_MODE ADD CONSTRAINT PUBLIC.CONSTRAINT_E PRIMARY KEY(ID);
-- 89 +/- SELECT COUNT(*) FROM PUBLIC.GAME_MODE;               
INSERT INTO PUBLIC.GAME_MODE(ID, GAME_ID, MODE_ID) VALUES
(36, 32, 8),
(37, 32, 35),
(44, 42, 8),
(52, 49, 8),
(53, 49, 17),
(63, 59, 8),
(70, 68, 8),
(71, 68, 17),
(77, 75, 8),
(84, 80, 8),
(85, 80, 17),
(93, 90, 8),
(99, 97, 8),
(104, 102, 8),
(105, 102, 17),
(112, 109, 8),
(119, 116, 8),
(126, 124, 8),
(127, 124, 17),
(133, 131, 8),
(134, 131, 35),
(140, 138, 8),
(145, 143, 8),
(150, 148, 8),
(156, 153, 8),
(163, 160, 8),
(169, 167, 8),
(170, 167, 17),
(176, 174, 8),
(177, 174, 17),
(185, 181, 8),
(191, 189, 8),
(192, 189, 35),
(199, 196, 8),
(200, 196, 35),
(201, 196, 17),
(208, 206, 8),
(213, 211, 8),
(219, 217, 8),
(220, 217, 35),
(226, 224, 8),
(227, 224, 17),
(233, 231, 8),
(241, 236, 8),
(249, 246, 8),
(258, 255, 8),
(266, 262, 8),
(274, 270, 8),
(282, 279, 8),
(287, 285, 8),
(292, 290, 8),
(297, 295, 8),
(298, 295, 35),
(306, 302, 8),
(314, 312, 8),
(319, 317, 8),
(324, 322, 8),
(331, 327, 8),
(338, 336, 8),
(339, 336, 17),
(346, 343, 8),
(353, 350, 8),
(359, 357, 8),
(365, 362, 8),
(366, 362, 35),
(373, 370, 8),
(380, 377, 8),
(386, 384, 8),
(392, 390, 17),
(398, 395, 8),
(404, 401, 8),
(411, 408, 8),
(418, 415, 8),
(425, 422, 8),
(432, 429, 8),
(439, 436, 8),
(445, 443, 8),
(452, 449, 8),
(453, 449, 35),
(460, 457, 8),
(461, 457, 35),
(479, 475, 8),
(488, 484, 8),
(495, 492, 8),
(496, 492, 17),
(661, 660, 8),
(662, 660, 17),
(663, 660, 35),
(684, 681, 8);  
-- CREATE CACHED TABLE PUBLIC.GENRE(
--     ID INTEGER NOT NULL,
--     GENRE VARCHAR(255)
-- );
-- ALTER TABLE PUBLIC.GENRE ADD CONSTRAINT PUBLIC.CONSTRAINT_4 PRIMARY KEY(ID);
-- 14 +/- SELECT COUNT(*) FROM PUBLIC.GENRE;   
INSERT INTO PUBLIC.GENRE(ID, GENRE) VALUES
(1, 'casual'),
(12, 'fps'),
(29, 'interactivedrama'),
(30, 'actionadventure'),
(40, 'adventure'),
(46, 'simulation'),
(47, 'racing'),
(56, 'rpg'),
(57, 'openworld'),
(122, 'action_adventure'),
(215, 'puzzle'),
(252, 'education'),
(253, 'designillustrator'),
(388, 'mmorpg');  
-- CREATE CACHED TABLE PUBLIC.MASTER_GAME(
--     ID INTEGER NOT NULL,
--     CONSOLE_MAP_ID INTEGER,
--     GAME_ID INTEGER,
--     GENRE_MAP_ID INTEGER,
--     MODE_MAP_ID INTEGER
-- );
-- ALTER TABLE PUBLIC.MASTER_GAME ADD CONSTRAINT PUBLIC.CONSTRAINT_C PRIMARY KEY(ID);
-- 177 +/- SELECT COUNT(*) FROM PUBLIC.MASTER_GAME;            
INSERT INTO PUBLIC.MASTER_GAME(ID, CONSOLE_MAP_ID, GAME_ID, GENRE_MAP_ID, MODE_MAP_ID) VALUES
(38, NULL, 32, 31, 36),
(39, NULL, 32, 33, 37),
(45, 43, 42, 41, 44),
(54, 51, 49, 48, 52),
(55, 51, 49, 50, 53),
(64, 62, 59, 58, 63),
(65, 62, 59, 60, NULL),
(66, 62, 59, 61, NULL),
(72, 69, 68, 67, 70),
(73, 69, 68, NULL, 71),
(78, 76, 75, 74, 77),
(86, 83, 80, 79, 84),
(87, 83, 80, 81, 85),
(88, 83, 80, 82, NULL),
(94, 92, 90, 89, 93),
(95, 92, 90, 91, NULL),
(100, 98, 97, 96, 99),
(106, 103, 102, 101, 104),
(107, 103, 102, NULL, 105),
(113, 111, 109, 108, 112),
(114, 111, 109, 110, NULL),
(120, 118, 116, 115, 119),
(121, 118, 116, 117, NULL),
(128, 125, 124, 123, 126),
(129, 125, 124, NULL, 127),
(135, 132, 131, 130, 133),
(136, 132, 131, NULL, 134),
(141, 139, 138, 137, 140),
(146, 144, 143, 142, 145),
(151, 149, 148, 147, 150),
(157, 155, 153, 152, 156),
(158, 155, 153, 154, NULL),
(164, 162, 160, 159, 163),
(165, 162, 160, 161, NULL),
(171, 168, 167, 166, 169),
(172, 168, 167, NULL, 170),
(178, 175, 174, 173, 176),
(179, 175, 174, NULL, 177),
(186, 184, 181, 180, 185),
(187, 184, 181, 182, NULL),
(193, 190, 189, 188, 191),
(194, 190, 189, NULL, 192),
(202, 198, 196, 195, 199),
(203, 198, 196, NULL, 200),
(204, 198, 196, NULL, 201),
(209, 207, 206, 205, 208),
(214, 212, 211, 210, 213),
(221, 218, 217, 216, 219),
(222, 218, 217, NULL, 220),
(228, 225, 224, 223, 226),
(229, 225, 224, NULL, 227),
(234, 232, 231, 230, 233),
(242, NULL, 236, 235, 241),
(243, NULL, 236, NULL, NULL),
(244, NULL, 236, 238, NULL),
(250, NULL, 246, 245, 249),
(251, NULL, 246, NULL, NULL),
(259, NULL, 255, 254, 258),
(260, NULL, 255, 256, NULL),
(267, 265, 262, 261, 266),
(268, 265, 262, NULL, NULL),
(275, NULL, 270, 269, 274),
(276, NULL, 270, 271, NULL),
(277, NULL, 270, NULL, NULL),
(283, 281, 279, 278, 282),
(288, 286, 285, 284, 287),
(293, 291, 290, 289, 292),
(299, 296, 295, NULL, 297),
(300, 296, 295, NULL, 298),
(307, 305, 302, NULL, 306),
(308, 305, 302, 303, NULL),
(309, 305, 302, 304, NULL),
(315, 313, 312, NULL, 314),
(320, 318, 317, 316, 319),
(325, 323, 322, 321, 324),
(332, NULL, 327, 326, 331),
(333, NULL, 327, 328, NULL),
(334, NULL, 327, NULL, NULL),
(340, 337, 336, 335, 338),
(341, 337, 336, NULL, 339),
(347, NULL, 343, 342, 346),
(348, NULL, 343, 344, NULL),
(354, NULL, 350, NULL, 353),
(355, NULL, 350, 351, NULL),
(360, NULL, 357, 356, 359),
(367, NULL, 362, 361, 365),
(368, NULL, 362, 363, 366),
(374, NULL, 370, 369, 373),
(375, NULL, 370, NULL, NULL),
(381, NULL, 377, 376, 380),
(382, NULL, 377, NULL, NULL),
(387, 385, 384, 383, 386),
(393, 391, 390, 389, 392),
(399, 397, 395, 394, 398),
(405, 403, 401, 400, 404),
(406, 403, 401, 402, NULL),
(412, 410, 408, 407, 411),
(413, 410, 408, 409, NULL),
(419, 417, 415, 414, 418),
(420, 417, 415, 416, NULL),
(426, 424, 422, 421, 425),
(427, 424, 422, 423, NULL),
(433, 431, 429, 428, 432),
(434, 431, 429, 430, NULL),
(440, 438, 436, 435, 439),
(441, 438, 436, 437, NULL),
(446, 444, 443, 442, 445),
(454, 451, 449, 448, 452),
(455, 451, 449, NULL, 453),
(462, 459, 457, 456, 460),
(463, 459, 457, NULL, 461),
(471, 468, 465, 464, NULL),
(472, 468, 465, 466, NULL),
(473, 468, 465, 467, NULL),
(480, 478, 475, 474, 479),
(481, 478, 475, 476, NULL),
(482, 478, 475, 477, NULL),
(489, 487, 484, 483, 488),
(490, 487, 484, 485, NULL),
(497, 494, 492, 491, 495),
(498, 494, 492, 493, 496),
(502, NULL, 32, 31, 36),
(503, NULL, 32, 33, 37),
(504, NULL, 32, NULL, NULL),
(505, NULL, 32, NULL, NULL),
(506, NULL, 32, NULL, NULL),
(508, 507, 32, 31, 36),
(509, 507, 32, 33, 37),
(542, NULL, 541, NULL, NULL),
(544, NULL, 543, NULL, NULL),
(546, NULL, 545, NULL, NULL),
(548, NULL, 547, NULL, NULL),
(550, NULL, 549, NULL, NULL),
(572, NULL, 571, NULL, NULL),
(578, NULL, 577, NULL, NULL),
(580, NULL, 579, NULL, NULL),
(582, NULL, 581, NULL, NULL),
(584, NULL, 583, NULL, NULL),
(586, NULL, 585, NULL, NULL),
(588, NULL, 587, NULL, NULL),
(590, NULL, 589, NULL, NULL),
(592, NULL, 591, NULL, NULL),
(594, NULL, 593, NULL, NULL),
(596, NULL, 595, NULL, NULL),
(598, NULL, 597, NULL, NULL),
(600, NULL, 599, NULL, NULL),
(602, NULL, 601, NULL, NULL); 
INSERT INTO PUBLIC.MASTER_GAME(ID, CONSOLE_MAP_ID, GAME_ID, GENRE_MAP_ID, MODE_MAP_ID) VALUES
(604, NULL, 603, NULL, NULL),
(606, NULL, 605, NULL, NULL),
(608, NULL, 607, NULL, NULL),
(610, NULL, 609, NULL, NULL),
(612, NULL, 611, NULL, NULL),
(614, NULL, 613, NULL, NULL),
(616, NULL, 615, NULL, NULL),
(618, NULL, 617, NULL, NULL),
(620, NULL, 619, NULL, NULL),
(622, NULL, 621, NULL, NULL),
(657, NULL, 653, 654, NULL),
(658, NULL, 653, 655, NULL),
(659, NULL, 653, 656, NULL),
(664, NULL, 660, NULL, 661),
(665, NULL, 660, NULL, 662),
(666, NULL, 660, NULL, 663),
(668, NULL, 667, NULL, NULL),
(670, 507, 32, 31, 36),
(671, 507, 32, 33, 37),
(672, 507, 32, NULL, NULL),
(674, 507, 32, 31, 36),
(675, 507, 32, 33, 37),
(676, 507, 32, NULL, NULL),
(677, 507, 32, 31, 36),
(678, 507, 32, 33, 37),
(679, 507, 32, 31, 36),
(680, 507, 32, 33, 37),
(686, 685, 681, 682, 684),
(687, 685, 681, 683, NULL),
(691, NULL, 690, NULL, NULL);             
-- CREATE CACHED TABLE PUBLIC.PLAYABLE_MODE(
--     ID INTEGER NOT NULL,
--     MODE VARCHAR(255)
-- );
-- ALTER TABLE PUBLIC.PLAYABLE_MODE ADD CONSTRAINT PUBLIC.CONSTRAINT_2A PRIMARY KEY(ID);
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.PLAYABLE_MODE;            
INSERT INTO PUBLIC.PLAYABLE_MODE(ID, MODE) VALUES
(8, 'single player'),
(17, 'online multiplayer'),
(35, 'offline multiplayer');               
ALTER TABLE PUBLIC.GAME_MODE ADD CONSTRAINT PUBLIC.FKSNULEOBB9KO0IDTCFL15UJ5SA FOREIGN KEY(MODE_ID) REFERENCES PUBLIC.PLAYABLE_MODE(ID) NOCHECK;
ALTER TABLE PUBLIC.GAME_GENRE ADD CONSTRAINT PUBLIC.FKJ47T9LFHTJ14LSG346BO3VUJV FOREIGN KEY(GAME_ID) REFERENCES PUBLIC.GAME(ID) NOCHECK;
ALTER TABLE PUBLIC.GAME_CONSOLE ADD CONSTRAINT PUBLIC.FKKRO7U8D787L8SIV8F0KQYSK7C FOREIGN KEY(GAME_ID) REFERENCES PUBLIC.GAME(ID) NOCHECK;
ALTER TABLE PUBLIC.MASTER_GAME ADD CONSTRAINT PUBLIC.FKEJV2F0BU55PAIYAWXHE0OWY0Q FOREIGN KEY(GENRE_MAP_ID) REFERENCES PUBLIC.GAME_GENRE(ID) NOCHECK;
ALTER TABLE PUBLIC.MASTER_GAME ADD CONSTRAINT PUBLIC.FKLFT0HRKU1NE40IJE8KENOCIX FOREIGN KEY(CONSOLE_MAP_ID) REFERENCES PUBLIC.GAME_CONSOLE(ID) NOCHECK;
ALTER TABLE PUBLIC.MASTER_GAME ADD CONSTRAINT PUBLIC.FK2H9LOIY6FU5CJHSDNE33RVJNB FOREIGN KEY(GAME_ID) REFERENCES PUBLIC.GAME(ID) NOCHECK;
ALTER TABLE PUBLIC.GAME_MODE ADD CONSTRAINT PUBLIC.FKRKPEWVON7COHNH0BKJGOKGFJ3 FOREIGN KEY(GAME_ID) REFERENCES PUBLIC.GAME(ID) NOCHECK;
ALTER TABLE PUBLIC.GAME_CONSOLE ADD CONSTRAINT PUBLIC.FKNOS8JKU1MJNT16YVO6YBMNYT8 FOREIGN KEY(CONSOLE_ID) REFERENCES PUBLIC.CONSOLE(ID) NOCHECK;
ALTER TABLE PUBLIC.MASTER_GAME ADD CONSTRAINT PUBLIC.FKBADQ8B1CM9VXV5UBOWBDLE2GP FOREIGN KEY(MODE_MAP_ID) REFERENCES PUBLIC.GAME_MODE(ID) NOCHECK;
ALTER TABLE PUBLIC.GAME_GENRE ADD CONSTRAINT PUBLIC.FKFGIEXXWMFERKXQBWBJS989EA9 FOREIGN KEY(GENRE_ID) REFERENCES PUBLIC.GENRE(ID) NOCHECK;
