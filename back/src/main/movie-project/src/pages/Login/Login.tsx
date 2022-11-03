import styled from 'styled-components';

const Login = () => {
  return (
    <LonginWrapper>
      <LoginContent>
        <LoginLabel>Email</LoginLabel>
        <LoginInput placeholder="email@example.com" />
        <LoginLabel>Password</LoginLabel>
        <LoginInput type="password" placeholder="● ● ● ● ●" />
        <LoginBtn>Sign In</LoginBtn>
        <UnderTextWrapper>
          <UnderText>Forgot Password</UnderText>
          <UnderText>Sign up</UnderText>
        </UnderTextWrapper>
      </LoginContent>
    </LonginWrapper>
  );
};

export default Login;

const LonginWrapper = styled.div`
  display: flex;
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
  border: 1px solid black;
  border-radius: 0.5rem;
  font-size: 1.2rem;
`;

const LoginLabel = styled.h3`
  font-size: 1rem;
  color: #b3b3b3;
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
