# plrestAPI
SELECT T.NUMERO_IONIX, T.DATA_ABERTURA, C.RIN, M.MOTIVO, C.ARMARIO FROM PLC7_IONIX_TRATAMENTO T, PLC7_IONIX_CHECKLIST C, PLC7_IONIX_MOTIVO M, PLC7_IONIX_TECNOLOGIA TEC WHERE T.ID_CHECKLIST = C.ID AND C.ID_MOTIVO = M.ID_MOTIVO AND C.ID_TECNOLOGIA = TEC.ID_TECNOLOGIA AND T.ID_STATUS = 4
