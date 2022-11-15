import styled from 'styled-components';
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const Login = () => {
  const [isValid, setIsValid] = useState(false);
  const [userInfo, setUserInfo] = useState({
    id: '',
    pw: '',
  });

  const handleInputId = e => {
    setUserInfo({
      ...userInfo,
      id: e.target.value,
    });
  };

  const handleInputPw = e => {
    setUserInfo({
      ...userInfo,
      pw: e.target.value,
    });
  };

  useEffect(() => {
    if (userInfo.id && userInfo.pw) {
      setIsValid(true);
    } else {
      setIsValid(false);
    }
  }, [userInfo]);

  return (
    <LonginWrapper>
      <LoginContent>
        <LoginLabel>Email</LoginLabel>
        <LoginInput
          placeholder="email@example.com"
          name="id"
          onChange={handleInputId}
        />
        <LoginLabel>Password</LoginLabel>
        <LoginInput
          type="password"
          placeholder="● ● ● ● ●"
          onChange={handleInputPw}
        />
        <LoginBtn disabled={!isValid}>Sign In</LoginBtn>
        <UnderTextWrapper>
          <UnderText>Forgot Password</UnderText>
          <Link to="/signup">
            <UnderText>Sign up</UnderText>
          </Link>
        </UnderTextWrapper>
      </LoginContent>
    </LonginWrapper>
  );
};

export default Login;

const LonginWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  margin-top: auto;
`;

const LoginContent = styled.div`
  width: 25rem;
  height: 20rem;
  margin: auto;
`;

const LoginInput = styled.input`
  width: 100%;
  height: 15%;
  margin-bottom: 1rem;
  padding-left: 1rem;
  border: 1px solid #03af59;
  border-radius: 0.5rem;
  font-size: 1.2rem;
  color: #f3f4f8;
`;

const LoginLabel = styled.h3`
  font-size: 1rem;
  color: #03af59;
  margin-top: 1rem;
  margin-bottom: 0.5rem;
`;

const LoginBtn = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 15%;
  margin-top: 1rem;
  border: 1px solid black;
  border-radius: 0.5rem;
  font-size: 1.2rem;
  color: white;
  background-color: #667080;
  cursor: pointer;

  :disabled {
    color: #858585;
    background-color: #535353;
  }
`;

const UnderTextWrapper = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 20%;
  margin-top: 1rem;
`;

const UnderText = styled.p`
  margin-top: 0.5rem;
  font-size: 0.9rem;
  font-weight: 700;
  color: #667080;
  text-decoration: underline;
  cursor: pointer;
`;
