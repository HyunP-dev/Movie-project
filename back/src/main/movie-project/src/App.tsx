import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [test, setTest] = useState('');

  useEffect(() => {
    axios
      .get('/api/test')
      .then(response => setTest(response.data))
      .catch(error => console.log(error));
  }, []);

  return <div>백엔드에서 가져온 데이터입니다 : {test}</div>;
}

export default App;
