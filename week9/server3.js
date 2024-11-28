const path = require('path');
 const filePath = 'C:/Users/pranay/OneDrive/Desktop/2nd yr/2nd sem/dvr report.docx'; //Any file path on your pc
 console.log('File Name:', path.basename(filePath));
 console.log('Directory Name:', path.dirname(filePath));
 console.log('File Extension:', path.extname(filePath));