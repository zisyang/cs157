--BEGIN TRANSACTION;

CREATE TABLE APLOLD
(MODEL      VARCHAR2(25)    NOT NULL,
 YEAR       VARCHAR2(4) NOT NULL,
 DESCRIPTION    VARCHAR2(51),
 LITRES     VARCHAR2(4),
 ENGINE_TYPE    VARCHAR2(3),
 CUBIC_INCHES   VARCHAR2(6),
 RLINK      NUMBER(4),
 PRIMARY KEY    (MODEL, YEAR, DESCRIPTION, LITRES, ENGINE_TYPE, CUBIC_INCHES),
 FOREIGN KEY    (RLINK) REFERENCES RADCRX);


INSERT INTO APLOLD VALUES ('CALAIS', '86', 'NA', '2.5', 'L4', '151', 665);
INSERT INTO APLOLD VALUES ('CALAIS', '86', 'NA', '3.0', 'V6', '184', 665);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '86', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '86', 'NA', '2.5', 'L4', '151', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '86', 'NA', '2.8', 'V6', '173', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '86', 'NA', '3.8', 'V6', '231', 665);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '86', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '86', 'NA', '5.0', 'V8', '305', 1701);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '86', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '305', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '86', 'NA', '5.0', 'V8', '307', 1703);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '86', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '307', 1702);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE (FWD)', '86', 'NA', '3.0', 'V6', '181', 665);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE (FWD)', '86', 'NA', '3.8', 'V6', '231', 665);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE (FWD)', '86', 'NA', '5.0', 'V6', '305', 665);
INSERT INTO APLOLD VALUES ('FIRENZA', '86', 'A/T', '1.8', 'L4', '112', 1708);
INSERT INTO APLOLD VALUES ('FIRENZA', '86', 'M/T', '1.8', 'L4', '112', 1709);
INSERT INTO APLOLD VALUES ('FIRENZA', '86', 'A/T', '2.0', 'L4', '121', 1710);
INSERT INTO APLOLD VALUES ('FIRENZA', '86', 'NA', '2.8', 'V6', '173', 665);
INSERT INTO APLOLD VALUES ('98 REGENCY (FWD)', '86', 'NA', '3.8', 'V6', '231', 665);
INSERT INTO APLOLD VALUES ('TORONADO', '86', 'NA', '3.8', 'V6', '231', 665);
INSERT INTO APLOLD VALUES ('CUTLASS CALAIS', '85', 'NA', '2.5', 'L4', '151', 1714);
INSERT INTO APLOLD VALUES ('CUTLASS CALAIS', '85', 'NA', '3.0', 'V6', '184', 1714);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '85', 'NA', '2.5', 'L4', '151', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '85', 'NA', '2.8', 'V6', '173', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '85', 'NA', '3.0', 'V6', '184', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '85', 'NA', '3.8', 'V6', '231', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '85', 'DIESEL', '4.3', 'V6', '263', 1720);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '85', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '85', 'NA', '5.0', 'V8', '307', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '85', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '307', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '85', 'DIESEL', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '85', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '85', 'WO/EXTRA CAPACITY COOLING', '5.0', 'V8', '307', 7887);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '85', 'W/EXTRA CAPACITY COOLING', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '85', 'DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '85', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '85', 'WO/EXTRA CAPACITY COOLING', '5.0', 'V8', '307', 7887);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '85', 'W/EXTRA CAPACITY COOLING', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '85', 'DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('FIRENZA', '85', 'NA', '1.8', 'L4', '112', 1733);
INSERT INTO APLOLD VALUES ('FIRENZA', '85', 'A/T', '2.0', 'L4', '121', 1734);
INSERT INTO APLOLD VALUES ('FIRENZA', '85', 'M/T', '2.0', 'L4', '121', 1735);
INSERT INTO APLOLD VALUES ('FIRENZA', '85', 'NA', '2.8', 'V6', '173', 1714);
INSERT INTO APLOLD VALUES ('98 REGENCY (FWD)', '85', 'WO/C.L.I.', '3.0', 'V6', '184', 1737);
INSERT INTO APLOLD VALUES ('98 REGENCY (FWD)', '85', 'W/C.L.I', '3.0', 'V6', '184', 1738);
INSERT INTO APLOLD VALUES ('98 REGENCY (FWD)', '85', 'NA', '3.8', 'V6', '231', 1738);
INSERT INTO APLOLD VALUES ('98 REGENCY (FWD)', '85', 'DIESEL', '4.3', 'V6', '263', 1740);
INSERT INTO APLOLD VALUES ('TORONADO', '85', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '85', 'DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '84', 'NA', '2.5', 'L4', '151', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '84', 'NA', '2.8', 'V6', '173', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '84', 'NA', '3.0', 'V6', '184', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '84', 'NA', '3.8', 'V6', '231', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '84', 'DIESEL', '4.3', 'V6', '260', 1720);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'DIESEL', '4.3', 'V6', '263', 1749);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'NA', '5.0', 'V8', '305', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '305', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'NA', '5.0', 'V8', '307', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '307', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '84', 'NA', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '84', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '84', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '84', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('98 RECENCY (RWD)', '84', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('98 RECENCY (RWD)', '84', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('98 RECENCY (RWD)', '84', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '84', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '84', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '84', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('FIRENZA', '84', 'NA', '1.8', 'L4', '112', 1764);
INSERT INTO APLOLD VALUES ('FIRENZA', '84', 'A/T', '2.0', 'L4', '121', 1765);
INSERT INTO APLOLD VALUES ('FIRENZA', '84', 'M/T', '2.0', 'L4', '121', 1766);
INSERT INTO APLOLD VALUES ('OMEGA', '84', 'A/T', '2.5', 'L4', '151', 1767);
INSERT INTO APLOLD VALUES ('OMEGA', '84', 'M/T', '2.5', 'L4', '151', 1768);
INSERT INTO APLOLD VALUES ('OMEGA', '84', 'NA', '2.8', 'V6', '173', 1769);
INSERT INTO APLOLD VALUES ('TORONADO', '84', 'NA', '4.1', 'V6', '252', 1770);
INSERT INTO APLOLD VALUES ('TORONADO', '84', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '84', 'DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '83', 'NA', '2.5', 'L4', '151', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '83', 'NA', '2.8', 'V6', '173', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '83', 'NA', '3.0', 'V6', '181', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '83', 'DIESEL', '4.3', 'V6', '263', 1776);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'DIESEL', '4.3', 'V6', '263', 1749);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'NA', '5.0', 'V8', '305', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'W/H.D.TRANS,O.C.', '5.0', 'V8', '305', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'NA', '5.0', 'V8', '307', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '307', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '83', 'DIESEL', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88', '83', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88', '83', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88', '83', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('DELTA 88', '83', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '83', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '83', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '83', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '83', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '83', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '83', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '83', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '83', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('FIRENZA', '83', 'NA', '1.8', 'L4', '110', 1733);
INSERT INTO APLOLD VALUES ('FIRENZA', '83', 'NA', '2.0', 'L4', '121', 1734);
INSERT INTO APLOLD VALUES ('OMEGA', '83', 'NA', '2.5', 'L4', '110', 1767);
INSERT INTO APLOLD VALUES ('OMEGA', '83', 'NA', '2.8', 'V6', '173', 3196);
INSERT INTO APLOLD VALUES ('TORONADO', '83', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('TORONADO', '83', 'NA', '4.1', 'V6', '252', 1770);
INSERT INTO APLOLD VALUES ('TORONADO', '83', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '83', 'W/C.L.I.,DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('TORONADO', '83', 'WO/C.L.I.DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '82', 'NA', '2.5', 'L4', '151', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '82', 'NA', '2.8', 'V6', '173', 1697);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '82', 'NA', '3.0', 'V6', '181', 1718);
INSERT INTO APLOLD VALUES ('CUTLASS CIERA', '82', 'DIESEL', '4.3', 'V6', '263', 1776);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'NA', '4.3', 'V8', '260', 1812);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'DIESEL', '4.3', 'V6', '263', 1749);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'NA', '4.4', 'V8', '267', 1812);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'NA', '5.0', 'V8', '305', 1810);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'NA', '5.0', 'V8', '307', 1810);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'W/H.D.TRANS.O.C.', '5.0', 'V8', '307', 1702);
INSERT INTO APLOLD VALUES ('CUTLASS SUPREME', '82', 'DIESEL', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'NA', '4.3', 'V8', '260', 1696);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'GAS ENGINE', '5.7', 'V8', '350', 1701);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'W/C.L.I DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('DELTA 88', '82', 'WO/C.L.I DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'NA', '4.3', 'V8', '260', 1696);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'GAS ENGINE', '5.7', 'V8', '350', 1701);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'W/C.L.I DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '82', 'WO/C.L.I DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'NA', '3.8', 'V6', '231', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'NA', '4.3', 'V8', '260', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'GAS ENGINE', '5.7', 'V8', '350', 1701);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'W/C.L.I DIESEL', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '82', 'WO/C.L.I DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('FIRENZA', '82', 'W/16 7/8 WIDE CORE', '1.8', 'L4', '110', 1838);
INSERT INTO APLOLD VALUES ('FIRENZA', '82', 'W/19 3/4 WIDE CORE', '1.8', 'L4', '110', 1839);
INSERT INTO APLOLD VALUES ('OMEGA', '82', 'NA', '2.5', 'L4', '151', 1767);
INSERT INTO APLOLD VALUES ('OMEGA', '82', 'NA', '2.8', 'V6', '173', 3196);
INSERT INTO APLOLD VALUES ('TORONADO', '82', 'NA', '4.1', 'V6', '252', 1770);
INSERT INTO APLOLD VALUES ('TORONADO', '82', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '82', 'DIESEL, WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('TORONADO', '82', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'NA', '4.3', 'V8', '260', 1847);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'STATION WAGON', '4.3', 'V8', '260', 1848);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'NA', '5.0', 'V8', '305', 7888);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'NA', '5.0', 'V8', '307', 7889);
INSERT INTO APLOLD VALUES ('CUTLASS', '81', 'DIESEL', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'NA', '4.3', 'V8', '260', 1854);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'NA', '5.0', 'V8', '307', 1854);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('DELTA 88', '81', 'NA', '5.7', 'V8', '350', 1726);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'NA', '4.3', 'V8', '260', 1854);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'NA', '5.0', 'V8', '307', 1854);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '81', 'NA', '5.7', 'V8', '350', 1726);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'NA', '4.1', 'V6', '252', 1725);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'NA', '4.3', 'V8', '260', 1854);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'NA', '5.0', 'V8', '307', 1854);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '81', 'NA', '5.7', 'V8', '350', 1726);
INSERT INTO APLOLD VALUES ('OMEGA', '81', 'NA', '2.5', 'L4', '151', 1873);
INSERT INTO APLOLD VALUES ('OMEGA', '81', 'NA', '2.8', 'V6', '173', 3196);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'NA', '3.8', 'V6', '231', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'NA', '4.1', 'V6', '252', 1696);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('TORONADO', '81', 'NA', '5.7', 'V8', '350', 1727);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'NA', '3.8', 'V6', '231', 1700);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'NA', '4.3', 'V8', '260', 1701);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'NA', '5.0', 'V8', '305', 1701);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'NA', '5.0', 'V8', '307', 1701);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'STATION WAGON', '5.0', 'V8', '307', 1722);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'NA', '5.7', 'V8', '350', 1886);
INSERT INTO APLOLD VALUES ('CUTLASS', '80', 'DIESEL', '5.7', 'V8', '350', 1724);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'NA', '4.3', 'V8', '265', 1701);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('DELTA 88', '80', 'NA', '5.7', 'V8', '350', 1696);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'NA', '4.3', 'V8', '265', 1701);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '80', 'NA', '5.7', 'V8', '350', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'NA', '3.8', 'V6', '231', 1852);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'NA', '4.3', 'V8', '265', 1701);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'NA', '5.0', 'V8', '307', 1696);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '80', 'NA', '5.7', 'V8', '350', 1696);
INSERT INTO APLOLD VALUES ('OMEGA', '80', 'NA', '2.5', 'L4', '151', 1873);
INSERT INTO APLOLD VALUES ('OMEGA', '80', 'NA', '2.8', 'V6', '173', 3196);
INSERT INTO APLOLD VALUES ('STARFIRE', '80', 'NA', '2.5', 'L4', '151', 1908);
INSERT INTO APLOLD VALUES ('STARFIRE', '80', 'NA', '3.8', 'V6', '231', 1909);
INSERT INTO APLOLD VALUES ('TORONADO', '80', 'NA', '5.0', 'V8', '307', 1727);
INSERT INTO APLOLD VALUES ('TORONADO', '80', 'DIESEL,WO/C.L.I.OPTION', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('TORONADO', '80', 'DIESEL,W/C.L.I.OPTION', '5.7', 'V8', '350', 1728);
INSERT INTO APLOLD VALUES ('TORONADO', '80', 'NA', '5.7', 'V8', '350', 1727);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'NA', '3.8', 'V6', '231', 1914);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'NA', '4.3', 'V8', '260', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'DIESEL', '4.3', 'V8', '260', 1916);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'NA', '5.0', 'V8', '305', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'NA', '5.7', 'V8', '350', 1918);
INSERT INTO APLOLD VALUES ('CUTLASS', '79', 'DIESEL', '5.7', 'V8', '350', 1919);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'NA', '3.8', 'V6', '231', 1920);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'NA', '4.9', 'V8', '301', 1921);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'DIESEL', '5.7', 'V8', '350', 1923);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('DELTA 88', '79', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'NA', '3.8', 'V6', '231', 1920);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'NA', '4.9', 'V8', '301', 1921);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'DIESEL', '5.7', 'V8', '350', 1923);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '79', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'NA', '3.8', 'V6', '231', 1920);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'NA', '4.9', 'V8', '301', 1921);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'DIESEL', '5.7', 'V8', '350', 1923);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '79', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('OMEGA', '79', 'NA', '3.8', 'V6', '231', 1938);
INSERT INTO APLOLD VALUES ('OMEGA', '79', 'NA', '5.0', 'V8', '305', 1939);
INSERT INTO APLOLD VALUES ('OMEGA', '79', 'NA', '5.7', 'V8', '350', 1940);
INSERT INTO APLOLD VALUES ('STARFIRE', '79', 'NA', '2.5', 'L4', '151', 1908);
INSERT INTO APLOLD VALUES ('STARFIRE', '79', 'NA', '3.8', 'V6', '231', 1942);
INSERT INTO APLOLD VALUES ('STARFIRE', '79', 'NA', '5.0', 'V8', '305', 1943);
INSERT INTO APLOLD VALUES ('TORONADO', '79', 'NA', '5.7', 'V8', '350', 1944);
INSERT INTO APLOLD VALUES ('TORONADO', '79', 'DIESEL', '5.7', 'V8', '350', 1804);
INSERT INTO APLOLD VALUES ('CUTLASS', '78', 'NA', '3.8', 'V6', '231', 1946);
INSERT INTO APLOLD VALUES ('CUTLASS', '78', 'NA', '4.3', 'V8', '260', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS', '78', 'NA', '5.0', 'V8', '305', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS', '78', 'NA', '5.7', 'V8', '350', 1918);
INSERT INTO APLOLD VALUES ('CUTLASS CRUISER', '78', 'NA', '3.8', 'V6', '231', 1946);
INSERT INTO APLOLD VALUES ('CUTLASS CRUISER', '78', 'NA', '4.3', 'V8', '260', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS CRUISER', '78', 'NA', '5.0', 'V8', '305', 1915);
INSERT INTO APLOLD VALUES ('CUTLASS CRUISER', '78', 'NA', '5.7', 'V8', '350', 1918);
INSERT INTO APLOLD VALUES ('DELTA 88', '78', 'NA', '3.8', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('DELTA 88', '78', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('DELTA 88', '78', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('DELTA 88', '78', 'DIESEL', '5.7', 'V8', '350', 1957);
INSERT INTO APLOLD VALUES ('DELTA 88', '78', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '78', 'NA', '3.8', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '78', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '78', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '78', 'DIESEL', '5.7', 'V8', '350', 1957);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '78', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '78', 'NA', '3.8', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '78', 'NA', '4.3', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '78', 'NA', '5.7', 'V8', '350', 1924);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '78', 'DIESEL', '5.7', 'V8', '350', 1957);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '78', 'NA', '6.6', 'V8', '403', 1924);
INSERT INTO APLOLD VALUES ('OMEGA', '78', 'NA', '3.8', 'V6', '231', 1938);
INSERT INTO APLOLD VALUES ('OMEGA', '78', 'NA', '5.0', 'V8', '305', 1939);
INSERT INTO APLOLD VALUES ('OMEGA', '78', 'NA', '5.7', 'V8', '350', 1940);
INSERT INTO APLOLD VALUES ('STARFIRE', '78', 'NA', '2.5', 'L4', '151', 1972);
INSERT INTO APLOLD VALUES ('STARFIRE', '78', 'NA', '3.8', 'V6', '231', 1909);
INSERT INTO APLOLD VALUES ('STARFIRE', '78', 'NA', '5.0', 'V8', '305', 1943);
INSERT INTO APLOLD VALUES ('TORONADO', '78', 'NA', '6.6', 'V8', '403', 1975);
INSERT INTO APLOLD VALUES ('CUTLASS', '77', 'NA', 'NA', 'V6', '231', 1976);
INSERT INTO APLOLD VALUES ('CUTLASS', '77', 'NA', 'NA', 'V8', '260', 1977);
INSERT INTO APLOLD VALUES ('CUTLASS', '77', 'NA', 'NA', 'V8', '350', 1978);
INSERT INTO APLOLD VALUES ('CUTLASS', '77', 'NA', 'NA', 'V8', '403', 1978);
INSERT INTO APLOLD VALUES ('VISTA CRUISER', '77', 'NA', 'NA', 'V6', '231', 1976);
INSERT INTO APLOLD VALUES ('VISTA CRUISER', '77', 'NA', 'NA', 'V8', '260', 1977);
INSERT INTO APLOLD VALUES ('VISTA CRUISER', '77', 'NA', 'NA', 'V8', '350', 1978);
INSERT INTO APLOLD VALUES ('VISTA CRUISER', '77', 'NA', 'NA', 'V8', '403', 1978);
INSERT INTO APLOLD VALUES ('DELTA 88', '77', 'NA', 'NA', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('DELTA 88', '77', 'NA', 'NA', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('DELTA 88', '77', 'NA', 'NA', 'V8', '350', 1954);
INSERT INTO APLOLD VALUES ('DELTA 88', '77', 'NA', 'NA', 'V8', '403', 1987);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '77', 'NA', 'NA', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '77', 'NA', 'NA', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '77', 'NA', 'NA', 'V8', '350', 1954);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '77', 'NA', 'NA', 'V8', '403', 1987);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '77', 'NA', 'NA', 'V6', '231', 1954);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '77', 'NA', 'NA', 'V8', '260', 1921);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '77', 'NA', 'NA', 'V8', '350', 1954);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '77', 'NA', 'NA', 'V8', '403', 1987);
INSERT INTO APLOLD VALUES ('OMEGA', '77', 'NA', 'NA', 'V6', '231', 1938);
INSERT INTO APLOLD VALUES ('OMEGA', '77', 'NA', 'NA', 'V8', '305', 1939);
INSERT INTO APLOLD VALUES ('OMEGA', '77', 'NA', 'NA', 'V8', '350', 1940);
INSERT INTO APLOLD VALUES ('STARFIRE', '77', 'NA', 'NA', 'L4', '140', 1999);
INSERT INTO APLOLD VALUES ('STARFIRE', '77', 'NA', 'NA', 'V6', '231', 2000);
INSERT INTO APLOLD VALUES ('STARFIRE', '77', 'NA', 'NA', 'V8', '305', 1943);
INSERT INTO APLOLD VALUES ('TORONADO', '77', 'NA', 'NA', 'V8', '403', 1975);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'WO/LOW COOLANT WARNING', 'NA', 'L6', '250', 1976);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'NA', 'NA', 'V8', '260', 2004);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'NA', 'NA', 'V8', '350', 2004);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'STATION WAGON', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'NA', 'NA', 'V8', '455', 2007);
INSERT INTO APLOLD VALUES ('CUTLASS', '76', 'STATION WAGON', 'NA', 'V8', '455', 2008);
INSERT INTO APLOLD VALUES ('DELTA 88', '76', 'NA', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('DELTA 88', '76', 'CUSTOM CRUISE. WAGON', 'NA', 'NA', 'NA', 2010);
INSERT INTO APLOLD VALUES ('DELTA 88', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '350', 2011);
INSERT INTO APLOLD VALUES ('DELTA 88', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('DELTA 88', '76', 'CUST.CRUISE WAG.WO/LOW COOL. WARNING,', 'NA', 'V8', '455', 2011);
INSERT INTO APLOLD VALUES ('ROYALE', '76', 'NA', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('ROYALE', '76', 'CUSTOM CRUISE. WAGON', 'NA', 'NA', 'NA', 2010);
INSERT INTO APLOLD VALUES ('ROYALE', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '350', 2011);
INSERT INTO APLOLD VALUES ('ROYALE', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('ROYALE', '76', 'CUST.CRUISE WAG.WO/LOW COOL. WARNING,', 'NA', 'V8', '455', 2011);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '76', 'NA', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '76', 'CUSTOM CRUISE. WAGON', 'NA', 'NA', 'NA', 2010);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '350', 2011);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '76', 'WO/LOW COOLANT WARNING', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '76', 'CUST.CRUISE WAG.WO/LOW COOL. WARNING,', 'NA', 'V8', '455', 2011);
INSERT INTO APLOLD VALUES ('OMEGA', '76', 'NA', 'NA', 'L6', '250', 1939);
INSERT INTO APLOLD VALUES ('OMEGA', '76', 'NA', 'NA', 'V8', '260', 2025);
INSERT INTO APLOLD VALUES ('OMEGA', '76', 'NA', 'NA', 'V8', '350', 2025);
INSERT INTO APLOLD VALUES ('STARFIRE', '76', 'NA', 'NA', 'V6', '231', 2000);
INSERT INTO APLOLD VALUES ('TORONADO', '76', 'NA', 'NA', 'V8', '455', 1975);
INSERT INTO APLOLD VALUES ('CUTLASS', '75', 'NA', 'NA', 'L6', '250', 1976);
INSERT INTO APLOLD VALUES ('CUTLASS', '75', 'NA', 'NA', 'V8', '260', 2030);
INSERT INTO APLOLD VALUES ('CUTLASS', '75', 'NA', 'NA', 'V8', '350', 2030);
INSERT INTO APLOLD VALUES ('CUTLASS', '75', 'NA', 'NA', 'V8', '455', 2030);
INSERT INTO APLOLD VALUES ('CUTLASS', '75', 'W/TRAILER TOW,', 'NA', 'V8', '455', 2033);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '75', 'WO/COOL PROBE', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '75', 'WO/COOL PROBE', 'NA', 'V8', '400', 1978);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '75', 'WO/COOL PROBE', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '75', 'WO/COOL PROBE,', 'NA', 'V8', '455', 1978);
INSERT INTO APLOLD VALUES ('NINETY EIGHT', '75', 'W/TRAILER TOW,', 'NA', 'V8', '455', 2033);
INSERT INTO APLOLD VALUES ('DELTA 88', '75', 'WO/COOL PROBE', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('DELTA 88', '75', 'WO/COOL PROBE', 'NA', 'V8', '400', 1978);
INSERT INTO APLOLD VALUES ('DELTA 88', '75', 'WO/COOL PROBE', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('DELTA 88', '75', 'WO/COOL PROBE,', 'NA', 'V8', '455', 1978);
INSERT INTO APLOLD VALUES ('DELTA 88', '75', 'W/TRAILER TOW,', 'NA', 'V8', '455', 2033);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '75', 'WO/COOL PROBE', 'NA', 'V8', '350', 2006);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '75', 'WO/COOL PROBE', 'NA', 'V8', '400', 1978);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '75', 'WO/COOL PROBE', 'NA', 'V8', '455', 2006);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '75', 'WO/COOL PROBE,', 'NA', 'V8', '455', 1978);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '75', 'W/TRAILER TOW,', 'NA', 'V8', '455', 2033);
INSERT INTO APLOLD VALUES ('OMEGA', '75', 'NA', 'NA', 'L6', '250', 1939);
INSERT INTO APLOLD VALUES ('OMEGA', '75', 'NA', 'NA', 'V8', '260', 2025);
INSERT INTO APLOLD VALUES ('OMEGA', '75', 'NA', 'NA', 'V8', '350', 2025);
INSERT INTO APLOLD VALUES ('STARFIRE', '75', 'NA', 'NA', 'V6', '231', 2000);
INSERT INTO APLOLD VALUES ('TORONADO', '75', 'NA', 'NA', 'V8', '455', 1975);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '74', 'W/HEATER RETURN LINE,', 'NA', 'V8', '350', 2054);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '74', 'NA', 'NA', 'V8', '350', 1976);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '74', 'NA', 'NA', 'V8', '455', 2056);
INSERT INTO APLOLD VALUES ('DELTA 88', '74', 'W/HEATER RETURN LINE,', 'NA', 'V8', '350', 2054);
INSERT INTO APLOLD VALUES ('DELTA 88', '74', 'NA', 'NA', 'V8', '350', 1976);
INSERT INTO APLOLD VALUES ('DELTA 88', '74', 'NA', 'NA', 'V8', '455', 2056);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '74', 'W/HEATER RETURN LINE,', 'NA', 'V8', '350', 2054);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '74', 'NA', 'NA', 'V8', '350', 1976);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '74', 'NA', 'NA', 'V8', '455', 2056);
INSERT INTO APLOLD VALUES ('CUTLASS', '74', 'NA', 'NA', 'V8', '350', 7890);
INSERT INTO APLOLD VALUES ('CUTLASS', '74', 'NA', 'NA', 'V8', '455', 2056);
INSERT INTO APLOLD VALUES ('OMEGA', '74', 'NA', 'NA', 'L6', '250', 2065);
INSERT INTO APLOLD VALUES ('OMEGA', '74', 'NA', 'NA', 'V8', '350', 2066);
INSERT INTO APLOLD VALUES ('TORONADO', '74', 'NA', 'NA', 'V8', '455', 1975);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '73', 'NA', 'NA', 'V8', '350', 2068);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '73', 'NA', 'NA', 'V8', '455', 2068);
INSERT INTO APLOLD VALUES ('DELTA 88', '73', 'NA', 'NA', 'V8', '350', 2068);
INSERT INTO APLOLD VALUES ('DELTA 88', '73', 'NA', 'NA', 'V8', '455', 2068);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '73', 'NA', 'NA', 'V8', '350', 2068);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '73', 'NA', 'NA', 'V8', '455', 2068);
INSERT INTO APLOLD VALUES ('CUTLASS', '73', 'NA', 'NA', 'V8', '350', 2074);
INSERT INTO APLOLD VALUES ('CUTLASS', '73', 'NA', 'NA', 'V8', '455', 2075);
INSERT INTO APLOLD VALUES ('OMEGA', '73', 'NA', 'NA', 'L6', '250', 2076);
INSERT INTO APLOLD VALUES ('OMEGA', '73', 'NA', 'NA', 'V8', '350', 2066);
INSERT INTO APLOLD VALUES ('TORONADO', '73', 'NA', 'NA', 'V8', '455', 2078);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '72', 'NA', 'NA', 'V8', '350', 2079);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '72', 'NA', 'NA', 'V8', '455', 2080);
INSERT INTO APLOLD VALUES ('DELTA 88', '72', 'NA', 'NA', 'V8', '350', 2079);
INSERT INTO APLOLD VALUES ('DELTA 88', '72', 'NA', 'NA', 'V8', '455', 2080);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '72', 'NA', 'NA', 'V8', '350', 2079);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '72', 'NA', 'NA', 'V8', '455', 2080);
INSERT INTO APLOLD VALUES ('CUTLASS', '72', 'NA', 'NA', 'V8', '350', 2085);
INSERT INTO APLOLD VALUES ('CUTLASS', '72', 'NA', 'NA', 'V8', '455', 7891);
INSERT INTO APLOLD VALUES ('CUSTOM CRUISER', '71', 'NA', 'NA', 'V8', '455', 2087);
INSERT INTO APLOLD VALUES ('DELTA 88 ROYALE', '71', 'NA', 'NA', 'V8', '455', 2087);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '71', 'NA', 'NA', 'V8', '455', 2087);
INSERT INTO APLOLD VALUES ('CUTLASS', '71', 'NA', 'NA', 'L6', '250', 2090);
INSERT INTO APLOLD VALUES ('CUTLASS', '71', 'NA', 'NA', 'V8', '350', 2092);
INSERT INTO APLOLD VALUES ('CUTLASS', '71', 'NA', 'NA', 'V8', '455', 2092);
INSERT INTO APLOLD VALUES ('DELTA 88', '71', 'NA', 'NA', 'V8', '350', 2093);
INSERT INTO APLOLD VALUES ('DELTA 88', '71', 'NA', 'NA', 'V8', '455', 2080);
INSERT INTO APLOLD VALUES ('CUTLASS', '70', 'NA', 'NA', 'L6', '250', 2090);
INSERT INTO APLOLD VALUES ('CUTLASS', '70', 'NA', 'NA', 'V8', '350', 2096);
INSERT INTO APLOLD VALUES ('CUTLASS', '70', '310 H.P.', 'NA', 'V8', '455', 2097);
INSERT INTO APLOLD VALUES ('CUTLASS', '70', '320/365 H.P.', 'NA', 'V8', '455', 2096);
INSERT INTO APLOLD VALUES ('DELTA 88', '70', 'NA', 'NA', 'V8', '350', 2099);
INSERT INTO APLOLD VALUES ('DELTA 88', '70', 'NA', 'NA', 'V8', '455', 2099);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '70', 'NA', 'NA', 'V8', '350', 2099);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '70', 'NA', 'NA', 'V8', '455', 2099);
INSERT INTO APLOLD VALUES ('DELMONT 88', '69', 'NA', 'NA', 'V8', '350', 2099);
INSERT INTO APLOLD VALUES ('DELMONT 88', '69', 'NA', 'NA', 'V8', '455', 2099);
INSERT INTO APLOLD VALUES ('DELTA 88', '69', 'NA', 'NA', 'V8', '350', 2099);
INSERT INTO APLOLD VALUES ('DELTA 88', '69', 'NA', 'NA', 'V8', '455', 2099);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '69', 'NA', 'NA', 'V8', '350', 2099);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '69', 'NA', 'NA', 'V8', '455', 2099);
INSERT INTO APLOLD VALUES ('F-85', '69', 'NA', 'NA', 'L6', '250', 2109);
INSERT INTO APLOLD VALUES ('F-85', '69', 'NA', 'NA', 'V8', '350', 2096);
INSERT INTO APLOLD VALUES ('F-85', '69', 'NA', 'NA', 'V8', '400', 2097);
INSERT INTO APLOLD VALUES ('CUTLASS', '69', 'NA', 'NA', 'L6', '250', 2109);
INSERT INTO APLOLD VALUES ('CUTLASS', '69', 'NA', 'NA', 'V8', '350', 2096);
INSERT INTO APLOLD VALUES ('CUTLASS', '69', 'NA', 'NA', 'V8', '400', 2097);
INSERT INTO APLOLD VALUES ('DELMONT 88', '67', 'NA', 'NA', 'V8', '330', 2115);
INSERT INTO APLOLD VALUES ('DELMONT 88', '67', 'NA', 'NA', 'V8', '425', 2115);
INSERT INTO APLOLD VALUES ('JETSTAR', '67', 'NA', 'NA', 'V8', '330', 2115);
INSERT INTO APLOLD VALUES ('JETSTAR', '67', 'NA', 'NA', 'V8', '425', 2115);
INSERT INTO APLOLD VALUES ('DELTA 88', '67', 'NA', 'NA', 'V8', '330', 2115);
INSERT INTO APLOLD VALUES ('DELTA 88', '67', 'NA', 'NA', 'V8', '425', 2115);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '67', 'NA', 'NA', 'V8', '330', 2115);
INSERT INTO APLOLD VALUES ('NINETY-EIGHT', '67', 'NA', 'NA', 'V8', '425', 2115);
INSERT INTO APLOLD VALUES ('F-85', '67', 'NA', 'NA', 'L6', '250', 2123);
INSERT INTO APLOLD VALUES ('F-85', '67', 'NA', 'NA', 'V8', '330', 2109);
INSERT INTO APLOLD VALUES ('F-85', '67', 'NA', 'NA', 'V8', '400', 2109);
INSERT INTO APLOLD VALUES ('CUTLASS', '67', 'NA', 'NA', 'L6', '250', 2123);
INSERT INTO APLOLD VALUES ('CUTLASS', '67', 'NA', 'NA', 'V8', '330', 2109);
INSERT INTO APLOLD VALUES ('CUTLASS', '67', 'NA', 'NA', 'V8', '400', 2109);
INSERT INTO APLOLD VALUES ('TORONADO', '67', 'NA', 'NA', 'V8', '425', 2129);
INSERT INTO APLOLD VALUES ('DELTA 88', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('DELTA 88', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('DYNAMIC 88', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('DYNAMIC 88', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('JETSTAR 1', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('JETSTAR 1', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('88', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('88', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('98', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('98', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('STARFIRE', '65', 'NA', 'NA', 'V8', '330', 2130);
INSERT INTO APLOLD VALUES ('STARFIRE', '65', 'NA', 'NA', 'V8', '425', 2130);
INSERT INTO APLOLD VALUES ('F-85', '65', 'NA', 'NA', 'V8', '330', 2142);
INSERT INTO APLOLD VALUES ('F-85', '65', 'NA', 'NA', 'V8', '400', 2142);

COMMIT;
