import styled from 'styled-components';
import { useState, useEffect } from 'react';

const SignUp = () => {
  const [isValid, setIsValid] = useState(false);
  const [confirmPw, setConfirmPw] = useState('');
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

  const hadleConfirmPw = e => {
    setConfirmPw(e.target.value);
  };

  useEffect(() => {
    if (userInfo.id && userInfo.pw && userInfo.pw === confirmPw) {
      setIsValid(true);
    } else {
      setIsValid(false);
    }
  }, [userInfo, confirmPw]);

  return (
    <LonginWrapper>
      <LoginContent>
        <LoginLabel>Email</LoginLabel>
        <LoginInput
          placeholder="email@example.com"
          name="id"
          onChange={handleInputId}
        />
        <LoginLabel>Nickname</LoginLabel>
        <LoginInput placeholder="Nickname" name="id" onChange={handleInputId} />
        <LoginLabel>Password</LoginLabel>
        <LoginInput
          type="password"
          placeholder="● ● ● ● ●"
          onChange={handleInputPw}
        />
        <LoginLabel>Confirm Password</LoginLabel>
        <LoginInput
          type="password"
          placeholder="● ● ● ● ●"
          onChange={hadleConfirmPw}
        />
        <UserInfoBox>
          <div>
            <LoginLabel>성별</LoginLabel>
            <SelectedBox>
              <option value="man">남성</option>
            </SelectedBox>
          </div>
          <div>
            <LoginLabel>생년월일</LoginLabel>
            <LoginInput type="date" value="2000-01-01" max="2022-01-01" />
          </div>
        </UserInfoBox>
        <LoginBtn disabled={!isValid}>계정 만들기</LoginBtn>
      </LoginContent>
    </LonginWrapper>
  );
};

export default SignUp;

const LonginWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 60vh;
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
  color: white;
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
  background-color: #03af59;
  cursor: pointer;

  :disabled {
    color: #858585;
    background-color: #535353;
  }
`;

const UserInfoBox = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  div {
    width: 100%;
    height: 8em;
    /* padding: 10px; */
  }

  input {
    width: 100%;
    height: 3rem;
    margin-left: 10px;
    color-scheme: dark;
  }
`;

const SelectedBox = styled.select`
  width: 100%;
  height: 3rem;
  padding-left: 1rem;
  margin-right: 10px;
  color: white;
  border: 1px solid #03af59;
  background-color: transparent;
  border-radius: 0.5rem;
`;
