import styled from 'styled-components';
import { BiUser } from 'react-icons/bi';
import { HiMagnifyingGlass } from 'react-icons/hi2';

const Navigation = () => {
  return (
    <NavWrapper>
      <NavLogo src="https://upload.wikimedia.org/wikipedia/commons/8/85/Logo-Test.png" />
      <NavSearchWrapper>
        <NavSearchIcon />
        <NavSearch />
      </NavSearchWrapper>
      <NavUserIcon />
    </NavWrapper>
  );
};

export default Navigation;

const NavWrapper = styled.div`
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  height: 10vh;
  border-bottom: 1px solid grey;
`;

const NavLogo = styled.img`
  width: 20%;
  height: 100%;
`;

const NavSearchWrapper = styled.div`
  position: relative;
  display: flex;
  align-items: center;
  width: 20%;
  height: 100%;
`;

const NavSearch = styled.input`
  width: 100%;
  height: 40%;
  padding-left: 2.5rem;
  border: 1px solid grey;
  border-radius: 1rem;
`;

const NavSearchIcon = styled(HiMagnifyingGlass)`
  position: absolute;
  left: 6%;
`;

const NavUserIcon = styled(BiUser)`
  width: 20%;
  height: 40%;
`;

// const NavUserIcon = styled(BiUser)`
//   height: 100%;
//   cursor: pointer;
// `;
