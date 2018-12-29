SELECT permission_level FROM User where id='CID00123' && password='12345';
SELECT * FROM User where id='CID00123';



-- Reports

SELECT C2.criminalId,C2.criminalName,C2.civilStatus,R.recordID,R.recordName FROM CriminalRecordDetails CD INNER JOIN Criminal C2 on CD.criminal_criminalId = C2.criminalId INNER JOIN Record R on CD.record_recordID = R.recordID;
SELECT * FROM CriminalRecordDetails CD INNER JOIN Criminal C2 on CD.criminal_criminalId = C2.criminalId INNER JOIN Record R on CD.record_recordID = R.recordID WHERE CD.criminal_criminalId=;
SELECT C2.criminalId,C2.criminalName,C2.criminalNickName,R.recordName, R.recordCategory,R.victimsName,R.incidentDate FROM CriminalRecordDetails CD INNER JOIN Criminal C2 on CD.criminal_criminalId = C2.criminalId INNER JOIN Record R on CD.record_recordID = R.recordID;
